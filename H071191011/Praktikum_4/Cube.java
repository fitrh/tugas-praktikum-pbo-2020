import java.util.Scanner;

class Cube extends Box
{
	@Override
	public void askParameters(Scanner sc, boolean surfaceArea)
	{
		System.out.print("Panjang Sisi: ");
		depth = height = width = Math.abs(sc.nextDouble());
	}
}
