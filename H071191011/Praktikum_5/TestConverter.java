public class TestConverter
{
	public static void main(String[] a)
	{
		ConverterData data = new ConverterData();

		// Link start!
		data.start();
		if (!compare(data.teraToGiga(1), 1024, "Terabyte To Gigabyte"))
			System.exit(1);
		if (!compare(data.teraToMega(1), 1048576, "Terabyte To Megabyte"))
			System.exit(1);
		if (!compare(data.teraToKilo(1), 1073741824, "Terabyte To Kilobyte"))
			System.exit(1);
		// Bye
		data.stop();
		System.out.println();

		ConverterTemperature temp = new ConverterTemperature();

		// Login
		temp.start();
		if (!compare(temp.celsiusToFahrenheit(0), 32.0, "Celsius to Fahrenheit"))
			System.exit(1);
		if (!compare(temp.celsiusToKelvin(-273.15), 0, "Celsius to Kelvin"))
			System.exit(1);
		// Logoff
		temp.stop();
		System.out.println();

		ConverterDistance dist = new ConverterDistance();

		// スタート
		dist.start();
		if (!compare(dist.inchToMeter(1000), 25.4, "Inch to Meter"))
			System.exit(1);
		if (!compare(dist.meterToKilo(1000), 1.0, "Meter to Kilometer"))
			System.exit(1);
		if (!compare(dist.meterToMilli(1), 1000, "Meter to Millimeter"))
			System.exit(1);
		// ストップ
		dist.stop();
	}

	private static boolean compare(long a, long b, String kind)
	{
		boolean result = a == b;
		if (result)
			System.out.println(kind + " = Ok");
		else
			System.out.println(kind + " = INCORRECT");
		return result;
	}

	private static boolean compare(double a, double b, String kind)
	{
		boolean result = Math.abs(a - b) < 0.0001;
		if (result)
			System.out.println(kind + " = Ok");
		else
			System.out.println(kind + " = INCORRECT");
		return result;
	}
}
