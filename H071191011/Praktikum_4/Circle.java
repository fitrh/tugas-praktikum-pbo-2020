import java.util.Scanner;

class Circle extends Shape
{
	private double radius;

	@Override
	public void askParameters(Scanner sc, boolean a)
	{
		System.out.print("Jari-jari: ");
		radius = sc.nextDouble();
	}

	@Override
	public double getArea()
	{
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter()
	{
		return 2 * Math.PI * radius;
	}

	public double getRadius()
	{
		return radius;
	}
}
