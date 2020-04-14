import java.util.Scanner;

public class Tugas1Main
{
	public static void main(String[] a)
	{
		Scanner sc = new Scanner(System.in);


		System.out.print("Bangun Ruang (1) atau Datar (2)? ");
		boolean isShape = sc.nextByte() == 2;

		if (isShape)
			System.out.print("Mencari luas (1) atau keliling (2)? ");
		else
			System.out.print("Mencari volume (1) atau luas permukaan (2)? ");
		boolean isPerimeter = sc.nextByte() == 2;

		if (isShape)
			readShape(sc, isPerimeter);
		else
			readGeometry(sc, isPerimeter);
	}

	private static void readShape(Scanner sc, boolean isPerimeter)
	{
		System.out.println("===== BANGUN DATAR =====");
		System.out.println("1. PERSEGI");
		System.out.println("2. PERSEGI PANJANG");
		System.out.println("3. LINGKARAN");
		System.out.println("4. SEGITIGA");
		System.out.println("5. TRAPESIUM");
		System.out.println("6. JAJARGENJANG");
		System.out.println("7. BELAH KETUPAT");
		System.out.println("8. LAYANG-LAYANG");

		System.out.print("Pilihan: ");
		byte type = sc.nextByte();
		Shape shape = null;
		switch (type)
		{
			case 1:
				shape = new Square();
				break;
			case 2:
				shape = new Rectangle();
				break;
			case 3:
				shape = new Circle();
				break;
			case 4:
				shape = new Triangle();
				break;
			case 5:
				shape = new Trapezoid();
				break;
			case 6:
				shape = new Parallelogram();
				break;
			case 7:
				shape = new Rhombus();
				break;
			case 8:
				shape = new Kite();
				break;
		}

		if (shape == null)
		{
			System.out.println("Input bangun datar tidak valid");
			return;
		}

		shape.askParameters(sc, isPerimeter);
		if (isPerimeter)
			System.out.printf("Keliling: %.2f\n", shape.getPerimeter());
		else
			System.out.printf("Luas: %.2f\n", shape.getArea());
	}

	private static void readGeometry(Scanner sc, boolean isSurfaceArea)
	{
		System.out.println("===== BANGUN RUANG =====");
		System.out.println("1. KUBUS");
		System.out.println("2. BALOK");
		System.out.println("3. PRISMA SEGITIGA");
		System.out.println("4. BOLA");
		System.out.println("5. TABUNG");
		System.out.println("6. LIMAS SEGITIGA");
		System.out.println("7. LIMAS SEGIEMPAT");
		System.out.println("8. KERUCUT");
		
		System.out.print("Pilihan: ");
		byte type = sc.nextByte();
		Geometry geo = null;
		switch (type)
		{
			case 1:
				geo = new Cube();
				break;
			case 2:
				geo = new Box();
				break;
			case 3:
				geo = new Prism(new Triangle());
				break;
			case 4:
				geo = new Sphere();
				break;
			case 5:
				geo = new Prism(new Circle());
				break;
			case 6:
				System.out.println("Perhatian: Pastikan 3 sisi segitiga yang dimasukkan sama");
				geo = new Pyramid(new Triangle());
				break;
			case 7:
				geo = new Pyramid(new Square());
				break;
			case 8:
				geo = new Pyramid(new Circle());
				break;
		}

		if (geo == null)
		{
			System.out.println("Input bangun ruang tidak valid");
			return;
		}

		geo.askParameters(sc, isSurfaceArea);
		if (isSurfaceArea)
			System.out.printf("Luas Permukaan: %.2f\n", geo.getSurfaceArea());
		else
			System.out.printf("Volume: %.2f\n", geo.getVolume());
	}
}
