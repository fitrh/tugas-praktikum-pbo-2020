import java.util.Scanner;

class Square extends Rectangle
{
	@Override
	public void askParameters(Scanner sc, boolean perimeter)
	{
		System.out.print("Panjang Sisi: ");
		height = width = Math.abs(sc.nextDouble());
	}

	public double getSideLength()
	{
		return width;
	}
}
