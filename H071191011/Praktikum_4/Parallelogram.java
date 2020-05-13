import java.util.Scanner;

class Parallelogram extends Rectangle
{
	private double sideLength;

	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		super.askParameters(sc, perimeter);
		if (perimeter)
		{
			System.out.print("Kemiringan (-90 < a < 90): ");
			double a = sc.nextDouble();
			assert (a > -90 && a < 90);
			sideLength = height / Math.cos(Math.toRadians(a));
		}
	}

	@Override
	public double getPerimeter()
	{
		return width + height + 2 * sideLength;
	}
}
