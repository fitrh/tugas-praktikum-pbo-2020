import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class Race
{
	public Race(String name)
	{
		this.name = name;
	}

	public void prepare()
	{
		System.out.println("Welcome to '" + name + "' race, we'll prepare the runners!");
		started = true;
	}

	public void abort()
	{
		System.out.println("'" + name + "' race canceled.");
		started = false;
		latchStart.countDown();
	}

	public void start()
	{
		if (participants < 4)
			throw new IllegalStateException("The race cannot be started, not enough runners");

		System.out.println("'" + name + "' race started!");
		latchStart.countDown();
	}

	public synchronized boolean hasStarted()
	{
		return started;
	}

	public void waitForGate() throws InterruptedException
	{
		synchronized(this)
		{
			participants++;
		}
		latchStart.await();
	}

	public synchronized void finish(String runnerName)
	{
		if (latchFinish != null)
		{
			latchFinish.countDown();
			winners.add(runnerName);
		}
	}

	public void result()
	{
		if (started == false)
			return;

		started = false;
		latchFinish = new CountDownLatch(participants);
		try
		{
			latchFinish.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			return;
		}

		System.out.println("The result of '" + name + "' race are:");
		for (int i = 0; i < winners.size(); i++)
			printRunnerResult(winners.get(i), i);
	}

	private void printRunnerResult(String name, int index)
	{
		String prefix;

		switch (index)
		{
			case 0:
			{
				prefix = "1st";
				break;
			}
			case 1:
			{
				prefix = "2nd";
				break;
			}
			case 2:
			{
				prefix = "3rd";
				break;
			}
			default:
			{
				prefix = "Lose";
				break;
			}
		}

		System.out.printf("%s: %s\n", prefix, name);
	}

	private String name;
	private ArrayList<String> winners = new ArrayList<String>();
	private boolean started = false;
	private CountDownLatch latchStart = new CountDownLatch(1);
	private CountDownLatch latchFinish;
	private int participants = 0;
}
