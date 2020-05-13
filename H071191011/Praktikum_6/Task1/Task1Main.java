import java.util.Scanner;

class Task1Main
{
	// Polymorphism, PBO halaman 31
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Employee employees[] = {
			readStaff(sc),
			readLecture(sc),
			readEmployee(sc)
		};

		for (Employee e: employees)
			System.out.printf("%s mendapatkan gaji Rp.%d\n", e.getName(), e.getSalary());
	}

	private static Staff readStaff(Scanner sc)
	{
		System.out.print("Nama Staf ::> ");
		String name = sc.nextLine();
		if (name.length() == 0)
			name = sc.nextLine();

		System.out.print("Jumlah Kehadiran ::> ");
		int attendance = sc.nextInt();

		return new Staff(name, attendance);
	}

	private static Lecture readLecture(Scanner sc)
	{
		System.out.print("Nama Dosen ::> ");
		String name = sc.nextLine();
		if (name.length() == 0)
			name = sc.nextLine();

		System.out.print("Jumlah SKS ::> ");
		int credits = sc.nextInt();

		return new Lecture(name, credits);
	}

	private static Employee readEmployee(Scanner sc)
	{
		System.out.print("Nama Pegawai ::> ");
		String name = sc.nextLine();
		if (name.length() == 0)
			name = sc.nextLine();
		
		return new Employee(name);
	}
}
