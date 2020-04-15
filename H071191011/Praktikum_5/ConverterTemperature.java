class ConverterTemperature extends Converter implements Temperature
{
	@Override
	public double celsiusToFahrenheit(double value)
	{
		return value * 9.0 / 5.0 + 32;
	}

	@Override
	public double celsiusToKelvin(double value)
	{
		return value + 273.15;
	}

	@Override
	public void start()
	{
		System.out.println("Temperature Converter is started");
	}

	@Override
	public void stop()
	{
		System.out.println("Temperature Converter is terminated");
	}
}
