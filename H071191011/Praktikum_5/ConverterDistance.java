class ConverterDistance extends Converter implements Distance
{

	@Override
	public double meterToKilo(double value)
	{
		return value / 1000.0;
	}

	@Override
	public double meterToMilli(double value)
	{
		return value * 1000.0;
	}

	@Override
	public double inchToMeter(double value)
	{
		return value * 0.0254;
	}

	@Override
	public void start()
	{
		System.out.println("Distance Converter is started");
	}

	@Override
	public void stop()
	{
		System.out.println("Distance Converter is terminated");
	}
}
