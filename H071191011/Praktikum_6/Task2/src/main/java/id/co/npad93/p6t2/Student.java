package id.co.npad93.p6t2;

class Student implements User
{
	static final String invalidSize = "Subjects, mid score, and final score length mismatch";

	class SubjectInfo
	{
		public Subject subject;
		public int midScore;
		public int finalScore;
	}

	Student(String name, String id, String major, Subject[] subjects, int[] midScore, int[] finalScore)
	{
		if (subjects.length != midScore.length || midScore.length != finalScore.length)
			throw new IllegalArgumentException(invalidSize);

		this.name = name;
		this.id = id;
		this.major = major;
		this.subjects = subjects;
		this.midScores = midScore;
		this.finalScores = finalScore;
	}

	public String getName()
	{
		return name;
	}

	public String getId()
	{
		return id;
	}

	public String getMajor()
	{
		return major;
	}

	public int getSubjectCount()
	{
		return subjects.length;
	}

	public void printSubjectInfo(int i)
	{
		if (i < 0 || i >= subjects.length)
			throw new IndexOutOfBoundsException("index out of range");
		
		Subject subject = subjects[i];
		double score = (midScores[i] + finalScores[i]) / 2.0;
		System.out.printf("Matakuliah     : %s\n", subject.getName());
		System.out.printf("Dosen Pengampuh: %s\n", subject.getLecture().getName());
		System.out.printf("Nilai Mid      : %d\n", midScores[i]);
		System.out.printf("Nilai Final    : %d\n", finalScores[i]);
		System.out.printf("Nilai Akhir    : %.01f\n", score);
		System.out.printf("Nilai Mutu     : %s\n", Main.convertScore(score));
	}

	public SubjectInfo getSubjectInfo(int i)
	{
		if (i < 0 || i >= subjects.length)
			throw new IndexOutOfBoundsException("index out of range");
		
		SubjectInfo out = new SubjectInfo();
		out.subject = subjects[i];
		out.midScore = midScores[i];
		out.finalScore = finalScores[i];
		return out;
	}

	private String name, id, major;
	private Subject[] subjects;
	private int[] midScores, finalScores;
}
