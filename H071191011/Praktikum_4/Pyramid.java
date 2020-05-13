import java.util.Scanner;

class Pyramid extends Geometry
{
	private Shape base;
	private double height;

	public Pyramid(Shape a)
	{
		base = a;
	}

	@Override
	public void askParameters(Scanner sc, boolean surfaceArea)
	{
		System.out.println("Untuk alas");
		base.askParameters(sc, surfaceArea);
		System.out.println("Untuk limas/kerucut");
		System.out.print("Tinggi: ");
		height = sc.nextDouble();
	}

	@Override
	public double getVolume()
	{
		return base.getArea() * height / 3.0;
	}

	@Override
	public double getSurfaceArea()
	{
		double slantHeight = 0;

		if (base instanceof Circle)
		{
			double r = ((Circle) base).getRadius();
			slantHeight = Math.sqrt(r * r + height * height);
		}
		else if (base instanceof Square)
		{
			double r = ((Square) base).getSideLength() * 0.5;
			slantHeight = Math.sqrt(r * r + height * height);
		}
		else if (base instanceof Triangle)
		{
			Triangle b = (Triangle) base;
			if (b.isEquilateral())
			{
				double sides = b.getPerimeter() / 3.0;
				slantHeight = Math.sqrt(3) * sides / 6;
			}
			else
				throw new UnsupportedOperationException("Unknown slant height");
		}
		else
			throw new UnsupportedOperationException("Unknown slant height");
		
		return base.getPerimeter() * slantHeight * 0.5;
	}
}
