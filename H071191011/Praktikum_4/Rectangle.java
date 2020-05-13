import java.util.Scanner;

class Rectangle extends Shape
{
	protected double width, height;

	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		System.out.print("Panjang/Alas: ");
		width = Math.abs(sc.nextDouble());
		System.out.print("Tinggi: ");
		height = Math.abs(sc.nextDouble());
	}

	@Override
	public double getArea()
	{
		return width * height;
	}

	@Override
	public double getPerimeter()
	{
		return 2 * width + 2 * height;
	}
}
