package id.co.npad93.p6t2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.json.*;

public class Main
{
	static HashMap<UUID, Lecture> lectureMap = new LinkedHashMap<UUID, Lecture>();
	static HashMap<UUID, Subject> subjectMap = new LinkedHashMap<UUID, Subject>();
	static HashMap<UUID, Student> studentMap = new LinkedHashMap<UUID, Student>();

	public static void main(String[] a)
	{
		System.out.println("Sistem Informasi Akademik");

		// Load JSON
		try
		{
			// Read JSON file
			JSONObject root = new JSONObject(readFile("sia.json"));

			// Read lecture list
			JSONArray lectures = root.getJSONArray("lectures");
			for (Object obj: lectures)
			{
				JSONObject lectureJSON = (JSONObject) obj;
				UUID uuid = UUID.fromString(lectureJSON.getString("uuid"));
				lectureMap.put(uuid, new Lecture(lectureJSON.getString("name")));
			}

			// Read subject list
			JSONArray subjects = root.getJSONArray("subjects");
			for (Object obj: subjects)
			{
				JSONObject subjectJSON = (JSONObject) obj;
				UUID uuid = UUID.fromString(subjectJSON.getString("uuid"));
				subjectMap.put(uuid, new Subject(
					subjectJSON.getString("name"),
					subjectJSON.getInt("credits"),
					lectureMap.get(UUID.fromString(subjectJSON.getString("lecture")))
				));
			}

			// Read student list
			JSONArray students = root.getJSONArray("students");
			for (Object obj: students)
			{
				JSONObject studentJSON = (JSONObject) obj;

				UUID uuid = UUID.fromString(studentJSON.getString("uuid"));
				String name = studentJSON.getString("name");
				String id = studentJSON.getString("id");
				String major = studentJSON.getString("major");

				// Read subjects
				JSONArray studentSubjects = studentJSON.getJSONArray("subjects");
				int subjectLength = studentSubjects.length();
				Subject[] subjectList = new Subject[subjectLength];
				int[] midScores = new int[subjectLength];
				int[] finalScores = new int[subjectLength];

				for (int i = 0; i < subjectLength; i++)
				{
					JSONObject subjectData = studentSubjects.getJSONObject(i);
					subjectList[i] = subjectMap.get(UUID.fromString(subjectData.getString("subject")));
					midScores[i] = subjectData.getInt("mid_score");
					finalScores[i] = subjectData.getInt("final_score");
				}

				studentMap.put(uuid, new Student(name, id, major, subjectList, midScores, finalScores));
			}
		}
		catch (IOException e)
		{} // ok fine we should create new one later
		
		Scanner sc = new Scanner(System.in);
		mainLoop(sc);
		sc.close();

		try
		{
			// Write new sia.json
			LinkedHashMap<String, Object> root = new LinkedHashMap<String, Object>();
			
			// Write lecture list
			JSONArray lectures = new JSONArray();
			for (Map.Entry<UUID, Lecture> lecture: lectureMap.entrySet())
			{
				JSONObject obj = new JSONObject();
				obj.put("uuid", lecture.getKey().toString());
				obj.put("name", lecture.getValue().getName());
				lectures.put(obj);
			}

			// Write subject list
			JSONArray subjects = new JSONArray();
			for (Map.Entry<UUID, Subject> subject: subjectMap.entrySet())
			{
				JSONObject obj = new JSONObject();
				Subject s = subject.getValue();
				obj.put("uuid", subject.getKey().toString());
				obj.put("name", s.getName());
				obj.put("credits", s.getCredits());

				// This actually show but uh
				for (Map.Entry<UUID, Lecture> l: lectureMap.entrySet())
				{
					if (l.getValue() == s.getLecture())
					{
						obj.put("lecture", l.getKey().toString());
						break;
					}
				}

				subjects.put(obj);
			}

			// Write student list
			JSONArray students = new JSONArray();
			for (Map.Entry<UUID, Student> student: studentMap.entrySet())
			{
				JSONObject obj = new JSONObject();
				Student s = student.getValue();
				obj.put("uuid", student.getKey().toString());
				obj.put("name", s.getName());
				obj.put("id", s.getId());
				obj.put("major", s.getMajor());

				JSONArray subjectList = new JSONArray();
				for (int i = 0; i < s.getSubjectCount(); i++)
				{
					JSONObject subjectInfoObject = new JSONObject();
					Student.SubjectInfo info = s.getSubjectInfo(i);
					
					// This actually show but uh
					for (Map.Entry<UUID, Subject> l: subjectMap.entrySet())
					{
						if (l.getValue() == info.subject)
						{
							subjectInfoObject.put("subject", l.getKey().toString());
							break;
						}
					}

					subjectInfoObject.put("mid_score", new Integer(info.midScore));
					subjectInfoObject.put("final_score", new Integer(info.finalScore));
					subjectList.put(subjectInfoObject);
				}

				obj.put("subjects", subjectList);
				students.put(obj);
			}
		
			// Put to root object
			root.put("lectures", lectures);
			root.put("subjects", subjects);
			root.put("students", students);

			FileOutputStream output = new FileOutputStream("sia.json");
			OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);
			new JSONObject(root).write(writer, 4, 0);
			writer.close();
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static String convertScore(double v)
	{
		// https://unhas.ac.id/komunikasi/en/study/undergraduate-program/grading-system/
		if (v > 85)
			return "A";
		else if (v > 80)
			return "A-";
		else if (v > 75)
			return "B+";
		else if (v > 70)
			return "B";
		else if (v > 65)
			return "B-";
		else if (v > 60)
			return "C+";
		else if (v > 50)
			return "C";
		else if (v > 45)
			return "D";
		else
			return "E";
	}

	// Cannot use Files.readString(Paths.get(path), StandardCharsets.UTF_8)
	// as Files.readString function is Java 11
	static String readFile(String filename) throws IOException
	{
		final int BUFSIZE = 4096;

		FileInputStream input = new FileInputStream(filename);
		ByteArrayOutputStream tempOut = new ByteArrayOutputStream();

		// Read file in chunks
		byte[] buf = new byte[BUFSIZE];
		int readed = 0;
		do
		{
			readed = input.read(buf);
			tempOut.write(buf, 0, readed);
		} while (readed == BUFSIZE);

		String out = tempOut.toString("UTF-8");
		input.close();
		return out;
	}

	static void getUserInfo(User user)
	{
		System.out.println("Nama : " + user.getName());

		if (user instanceof Student)
		{
			Student s = (Student) user;
			System.out.println("NIM  : " + s.getId());
			System.out.println("Prodi: " + s.getMajor());

			int nSubjects = s.getSubjectCount();
	
			for (int j = 0; j < nSubjects; j++)
			{
				System.out.println("===============");
				s.printSubjectInfo(j);
			}
		}
		else if (user instanceof Lecture)
		{
			Lecture l = (Lecture) user;
			System.out.println("Daftar matakuliah pengampuh:");
			
			ArrayList<Subject> subjects = new ArrayList<Subject>();
			for (Subject s: subjectMap.values())
			{
				if (s.getLecture() == l)
					subjects.add(s);
			}

			for (int i = 1; i <= subjects.size(); i++)
				System.out.printf("%d. %s\n", i, subjects.get(i - 1).getName());
		}
	}

	static Lecture[] getLecture()
	{
		Collection<Lecture> a = lectureMap.values();
		Lecture[] b = new Lecture[a.size()];
		a.toArray(b);
		return b;
	}

	static Lecture getLecture(Scanner sc)
	{
		int n = sc.nextInt();
	
		if (n <= 0)
			return null;
		
		Lecture[] list = getLecture();	
		if (n > list.length)
			return null;
		
		return list[n - 1];
	}

	static Subject[] getSubject(Subject[] exclude)
	{
		Collection<Subject> a = subjectMap.values();
		ArrayList<Subject> b = new ArrayList<Subject>();

		for (Subject c: a)
		{
			boolean found = false;

			if (exclude != null)
			{
				for (int i = 0; i < exclude.length; i++)
				{
					if (exclude[i] == c)
					{
						found = true;
						break;
					}
				}
			}

			if (found == false)
				b.add(c);
		}

		Subject[] d = new Subject[b.size()];
		b.toArray(d);
		return d;
	}

	static Subject getSubject(Scanner sc, Subject[] list)
	{
		int n = sc.nextInt();
		
		if (n == 0)
			return null;

		if (list == null)
			list = getSubject(null);

		if (n > list.length)
			return null;
		
		return list[n - 1];
	}

	static Student[] getStudent()
	{
		Collection<Student> a = studentMap.values();
		Student[] b = new Student[a.size()];
		a.toArray(b);
		return b;
	}

	static Student getStudent(Scanner sc)
	{
		int n = sc.nextInt();
		
		if (n == 0)
			return null;

		Student[] list = getStudent();
		if (n > list.length)
			return null;
		
		return list[n - 1];
	}

	static int countDigits(long v)
	{
		int a = v < 0 ? 1 : 0;
		for (; v != 0; a++, v /= 10);
		return a;
	}

	static String repeat(String i, int n)
	{
		return String.join("", Collections.nCopies(n, i));
	}

	static void mainLoop(Scanner sc)
	{
		while (true)
		{
			System.out.println("Pilih opsi:");
			System.out.println("0. Keluar");
			System.out.println("1. Daftar Dosen");
			System.out.println("2. Daftar Matakuliah");
			System.out.println("3. Informasi Mahasiswa");
			System.out.println("4. Tambah Dosen");
			System.out.println("5. Tambah Matakuliah");
			System.out.println("6. Tambah Mahasiswa");
			System.out.print("Pilihan: ");
			int selection = sc.nextInt();

			switch (selection)
			{
				case 0: return;
				case 1:
				{
					System.out.println("Daftar dosen, pilih untuk info lebih lanjut:");
					Lecture[] lectures = getLecture();

					System.out.println("0. Batal");
					for (int i = 1; i <= lectures.length; i++)
						System.out.printf("%d. %s\n", i, lectures[i - 1].getName());
					
					Lecture target = getLecture(sc);
					if (target != null)
						getUserInfo(target);

					break;
				}
				case 2:
				{
					System.out.println("Daftar matakuliah:");
					Subject[] subjects = getSubject(null);

					for (int i = 1; i <= subjects.length; i++)
					{
						int n = countDigits(i);
						String formatter = String.format("%%0%dd. %%s\n", n);
						Subject s = subjects[i - 1];

						System.out.printf(formatter, i, s.getName());
						System.out.print(repeat(" ", n));
						System.out.println("  SKS: " + s.getCredits());
					}

					break;
				}
				case 3:
				{
					System.out.println("Informasi mahasiswa:");
					Student[] student = getStudent();

					System.out.println("0. Batal");
					for (int i = 1; i <= student.length; i++)
						System.out.printf("%d. %s\n", i, student[i - 1].getName());
					
					System.out.print("Pilih: ");
					Student s = getStudent(sc);
					if (s != null)
						getUserInfo(s);

					break;
				}
				case 4:
				{
					sc.nextLine();
					System.out.print("Nama Dosen: ");
					String name = sc.nextLine();

					if (name.equals("") == false)
					{
						lectureMap.put(UUID.randomUUID(), new Lecture(name));
						System.out.println("Dosen ditambahkan");
					}

					break;
				}
				case 5:
				{
					sc.nextLine();
					System.out.print("Nama Matakuliah: ");
					String name = sc.nextLine();

					if (name.equals(""))
						break;
					
					System.out.print("SKS: ");
					int credits = sc.nextInt();
					if (credits < 1)
						break;
					
						
					Lecture[] list = getLecture();

					System.out.println("Dosen pengampuh:");
					System.out.println("0. Batal");
					for (int i = 1; i <= list.length; i++)
						System.out.printf("%d. %s\n", i, list[i - 1].getName());

					System.out.print("Pilih: ");
					Lecture lecture = getLecture(sc);
					if (lecture == null)
						break;
					
					subjectMap.put(UUID.randomUUID(), new Subject(name, credits, lecture));
					System.out.println("Matakuliah ditambahkan");
					break;
				}
				case 6:
				{
					sc.nextLine();
					System.out.print("Nama Mahasiswa: ");
					String name = sc.nextLine();

					if (name.equals(""))
						break;
					
					System.out.print("NIM: ");
					String id = sc.nextLine();
					if (id.equals(""))
						break;
					
					System.out.print("Prodi: ");
					String major = sc.nextLine();
					if (major.equals(""))
						break;
					
					ArrayList<Subject> subjects = new ArrayList<Subject>();
					ArrayList<Integer> midScores = new ArrayList<Integer>();
					ArrayList<Integer> finalScores = new ArrayList<Integer>();
					for (int i = 1; i <= 8; i++)
					{
						Subject[] existingSubject = new Subject[subjects.size()];
						subjects.toArray(existingSubject);
						Subject[] included = getSubject(existingSubject);

						System.out.printf("Pilih matakuliah (%d/8):\n", i);
						System.out.println("0. Selesai");

						for (int j = 0; j < included.length; j++)
							System.out.printf("%d. %s\n", j + 1, included[j].getName());
						
						System.out.print("Pilih: ");
						Subject insertedSubject = getSubject(sc, included);
						if (insertedSubject == null)
							break;
						
						System.out.print("Nilai UTS: ");
						int midScore = sc.nextInt();

						System.out.print("Nilai UAS: ");
						int finalScore = sc.nextInt();

						subjects.add(insertedSubject);
						midScores.add(midScore);
						finalScores.add(finalScore);
					}

					Subject[] subjectArray = new Subject[subjects.size()];
					int[] scoresM = new int[midScores.size()];
					int[] scoresF = new int[finalScores.size()];
					subjects.toArray(subjectArray);
					for (int i = 0; i < scoresM.length; scoresM[i] = midScores.get(i), i++);
					for (int i = 0; i < scoresF.length; scoresF[i] = finalScores.get(i), i++);

					studentMap.put(UUID.randomUUID(), new Student(name, id, major, subjectArray, scoresM, scoresF));
					System.out.println("Mahasiswa ditambahkan");
					break;
				}
				default:
				{
					System.out.println("Pilihan tidak benar");
					break;
				}
			}
		}
	}
}
