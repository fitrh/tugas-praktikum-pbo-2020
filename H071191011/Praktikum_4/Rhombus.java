import java.util.Scanner;

class Rhombus extends Shape
{
	private double d1, d2;

	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		System.out.print("Panjang 2 panjang diagonal: ");
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
		return 4 * Math.sqrt(d1 * d1 / 4 + d2 * d2 / 4);
	}
}
