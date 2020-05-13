import java.util.Scanner;

class Trapezoid extends Shape
{
	private double a, b, c, d;
	private double height;

	private void askParameters(Scanner sc)
	{
		System.out.print("Panjang sisi bawah: ");
		a = sc.nextDouble();
		System.out.print("Panjang sisi atas: ");
		b = sc.nextDouble();
		System.out.print("Tinggi: ");
		height = sc.nextDouble();
	}

	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		if (perimeter)
		{
			// Minta jenis trapesium
			System.out.print("Trapesium sembarang (1), sama kaki (2), atau siku-siku (3)? ");
			byte type = sc.nextByte();

			if (type <= 0 || type > 3)
			{
				System.out.println("Diluar rentang. Asumsi sama kaki.");
				type = 2;
			}

			switch (type)
			{
				default:
				case 1:
				{
					System.out.print("Panjang sisi bawah: ");
					a = sc.nextDouble();
					System.out.print("Panjang sisi atas: ");
					b = sc.nextDouble();
					System.out.print("Panjang sisi kiri: ");
					c = sc.nextDouble();
					System.out.print("Panjang sisi kanan: ");
					d = sc.nextDouble();
					break;
				}
				case 2:
				{
					askParameters(sc);
					// Hitung sisi kiri dan kanan dari parameter yang ada
					c = height;
					double diff = Math.abs(a - b);
					d = Math.sqrt(c * c + diff * diff);
					break;
				}
				case 3:
				{
					askParameters(sc);
					// Hitung sisi kiri dan kanan dari parameter yang ada
					double diff = Math.abs(a - b) * 0.5;
					c = d = Math.sqrt(diff * diff + height * height);
					break;
				}
			}
		}
		else
			askParameters(sc);
	}

	@Override
	public double getArea()
	{
		return (a + b) * height * 0.5;
	}

	@Override
	public double getPerimeter()
	{
		return a + b + c + d;
	}
}
