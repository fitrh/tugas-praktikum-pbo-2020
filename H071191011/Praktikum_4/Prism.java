import java.util.Scanner;

class Prism extends Geometry
{
	private Shape base;
	private double height;

	public Prism(Shape base)
	{
		this.base = base;
	}

	@Override
	public void askParameters(Scanner sc, boolean surfaceArea)
	{
		System.out.println("Untuk alas");
		base.askParameters(sc, surfaceArea);
		System.out.println("Untuk prisma/tabung");
		System.out.print("Tinggi: ");
		height = sc.nextDouble();
	}

	@Override
	public double getVolume()
	{
		return base.getArea() * height;
	}

	@Override
	public double getSurfaceArea()
	{
		return base.getPerimeter() * height + 2 * base.getArea();
	}
}
