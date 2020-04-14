import java.util.Scanner;

class Triangle extends Shape
{
	private double a, b, c;

	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		if (perimeter)
		{
			// TODO: Check whetever the sides are valid?
			System.out.println("Peringatan: tidak ada pengecekan panjang sisi");
			System.out.print("3 panjang sisi: ");
			a = sc.nextDouble();
			b = sc.nextDouble();
			c = sc.nextDouble();
		}
		else
		{
			System.out.print("Alas: ");
			a = sc.nextDouble();
			System.out.print("Tinggi: ");
			b = sc.nextDouble();
		}
	}

	@Override
	public double getArea()
	{
		return a * b * 0.5;
	}

	@Override
	public double getPerimeter()
	{
		return a + b + c;
	}

	public boolean isEquilateral()
	{
		return a == b && b == c;
	}
}
