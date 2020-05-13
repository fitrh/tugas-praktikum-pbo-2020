import java.util.Scanner;

class Sphere extends Geometry
{
	private double radius;

	@Override
	public void askParameters(Scanner sc, boolean surfaceArea)
	{
		System.out.print("Jari-jari: ");
		radius = sc.nextDouble();
	}

	@Override
	public double getVolume()
	{
		return getSurfaceArea() * radius / 3.0;
	}

	@Override
	public double getSurfaceArea()
	{
		return 4 * Math.PI * radius * radius;
	}
}
