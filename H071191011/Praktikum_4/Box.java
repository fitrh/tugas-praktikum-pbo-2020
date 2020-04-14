import java.util.Scanner;

class Box extends Geometry
{
	protected double width, height, depth;

	@Override
	public void askParameters(Scanner sc, boolean surfaceArea)
	{
		System.out.print("Panjang: ");
		width = sc.nextDouble();
		System.out.print("Lebar: ");
		height = sc.nextDouble();
		System.out.print("Tinggi: ");
		depth = sc.nextDouble();
	}

	@Override
	public double getVolume()
	{
		return width * height * depth;
	}

	@Override
	public double getSurfaceArea()
	{
		return 2 * width * height + 2 * width * depth + 2 * height * depth;
	}
}
