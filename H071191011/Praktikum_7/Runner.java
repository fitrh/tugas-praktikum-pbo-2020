class Runner implements Runnable
{
	public Runner(String name)
	{
		if (name == null)
			throw new NullPointerException("name");

		this.name = name;
	}

	@Override
	public void run()
	{
		try
		{
			race.waitForGate();
			while (race.hasStarted())
				counter++;

			race.finish(name);
		}
		catch (InterruptedException e)
		{}
	}

	public void start()
	{
		if (race == null)
			throw new IllegalStateException("Runner '" + name + "' have not entered any race");		
		if (race.hasStarted() == false)
			throw new IllegalStateException("Runner '" + name + "' attempt to run but the race hasn't started yet");

		thread = new Thread(this);
		thread.start();
	}

	public String getName()
	{
		return name;
	}

	public long getCounter()
	{
		return counter;
	}

	public void joinRace(Race race)
	{
		this.race = race;
	}

	public void syncThread()
	{
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{}
	}

	private String name;
	private long counter = 0;
	private Thread thread;
	private Race race;
}
