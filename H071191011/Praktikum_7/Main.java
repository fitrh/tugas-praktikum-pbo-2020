import java.util.*;

public class Main
{
	public static void main(String[] a)
	{
		Random rng = new Random();

		// Shuffle runner names
		for (int i = 0; i < runnerNames.length; i++)
		{
			int r1 = rng.nextInt(runnerNames.length);
			int r2 = rng.nextInt(runnerNames.length);
			String rn1 = runnerNames[r1];
			runnerNames[r1] = runnerNames[r2];
			runnerNames[r2] = rn1;
		}

		String raceName = raceNames[rng.nextInt(raceNames.length)];
		Race race = new Race(raceName);

		int participants = (int) (rng.nextDouble() * runnerNames.length);
		// Limit to 6 participants to reduce lags
		participants = Math.min(participants, 6);
		Runner[] runners = new Runner[participants];

		for (int i = 0; i < participants; i++)
		{
			String name = runnerNames[i];
			Runner r = runners[i] = new Runner(name);
			
			if (rng.nextDouble() <= 0.05)
			{
				if (tryRun(r))
					System.exit(1);
			}

			System.out.println("Runner '" + name + "' joining the race");
			r.joinRace(race);

			if (rng.nextDouble() <= 0.05)
			{
				if (tryRun(r))
					System.exit(1);
			}
		}

		try
		{
			long time = participants * 1000;
			System.out.println("Race duration: " + participants + " seconds");

			race.prepare();

			for (Runner r: runners)
				r.start();

			Thread.sleep(1000);
			race.start();
			Thread.sleep(time);
			race.result();
		}
		catch (IllegalStateException e)
		{
			System.out.println(e.getMessage());
			race.abort();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static boolean tryRun(Runner r)
	{
		try
		{
			System.out.println("Runner '" + r.getName() + "' wants to race now");
			r.start(); // should error
			System.out.println("and actually '" + r.getName() + "' run, which is critical error");
			return true;
		}
		catch (IllegalStateException e)
		{
			System.out.println(e.getMessage());
		}

		return false;
	}

	private static String[] runnerNames = {
		"Soeharto",
		"Ghana Pallbearers",
		"NPad93",
		"Tae Hanazono",
		"あみかりずか",
		"Big Smoke",
		"NoobMaster69",
		"ParashockX",
		"LazyKill",
		"PandaNuisance",
		"miaowmerE",
		"Cheems",
		"めらみぽっぷ",
		"Sanae Kochiya",
		"Monika"
	};

	private static String[] raceNames = {
		"Death Valley",
		"Astronomia",
		"Creeper Mountain",
		"AuahDark's Palace",
		"Corridors of Time",
	};
}
