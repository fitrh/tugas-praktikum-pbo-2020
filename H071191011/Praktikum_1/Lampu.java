class Lampu
{
	private boolean blueIsOn = true, redIsOn = false;

	public void turnOn()
	{
		if (blueIsOn)
		{
			blueIsOn = false;
			redIsOn = true;
		}
		else
		{
			blueIsOn = true;
			redIsOn = false;
		}
	}

	public void turnOff()
	{
		blueIsOn = redIsOn = false;
	}

	public String getState()
	{
		return "Lampu biru " + (blueIsOn ? "menyala" : "mati") + " dan lampu merah " + (redIsOn ? "menyala" : "mati");
	}
}
