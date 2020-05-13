import java.util.Scanner;

class Kite extends Shape
{
	private double d1, d2;

	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		if (perimeter)
			System.out.print("Panjang 2 sisi luar: ");
		else
			System.out.print("Panjang 2 sisi diagonal: ");

		d1 = sc.nextDouble();
		d2 = sc.nextDouble();
	}

	@Override
	public double getArea()
	{
		return d1 * d2 * 0.5;
	}

	@Override
	public double getPerimeter()
	{
		return 2 * d1 + 2 * d2;
	}
}
