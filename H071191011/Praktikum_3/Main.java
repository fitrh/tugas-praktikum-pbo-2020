import java.util.Random;

class Main
{
	public static void main(String[] args) 
	{
		Player npad = new Player("AuahDark", "Fighter");
		npad.healing(400.0);
		npad.setLevel(38);
		npad.setDamage(15.0);

		Player rizka = new Player("Amika Rizka", "Fighter");
		rizka.healing(400.0);
		rizka.setLevel(36);
		rizka.setDamage(12.0);

		// "java.util.Random always fair" - Fitrah
		Random rng = new Random();

		npad.showStatus();
		System.out.println();
		rizka.showStatus();
		System.out.println();

		// Buy items or fight?
		if (rng.nextDouble() >= 0.5)
			fight(rng, npad, rizka);
		else
			items(npad, rizka);
	}

	private static void fight(Random rng, Player npad, Player rizka)
	{
		double npadChance = 12.0 / (15.0 + 12.0);

		// Some dialogues and stuff
		// and spoiler for my game storyline
		System.out.println("AS-S3");
		System.out.println("AuahDark: Uh, what happend to everyone?");
		System.out.println("Amika: AuahDark, why we meet here? Also what happend to everyone?");
		System.out.println("AuahDark: Looks like our genetics can resist something.");
		System.out.println("Amika: Yeah. What about we resume our fight which was interrupted before?");
		System.out.println("AuahDark: Maybe, that's a good idea.");
		System.out.println();

		// Let's add 10 item that restores 50 HP and 5 item that restores 50 Energy for each
		for (int i = 0; i < 10; i++)
		{
			npad.addItem(new Item("HP Restorator Fifties", "Made in Utpala Industries. Restores 50 HP!", 0));
			rizka.addItem(new Item("HP Restorator Fifties", "Made in Utpala Industries. Restores 50 HP!", 0));
		}
		for (int i = 0; i < 5; i++)
		{
			npad.addItem(new Item("Energy Restorator Fifties", "Made in Utpala Industries. Restores 50 energy!", 0));
			rizka.addItem(new Item("Energy Restorator Fifties", "Made in Utpala Industries. Restores 50 energy!", 0));
		}

		// Items checklist
		System.out.println("Items Checklist");
		System.out.println(npad.getName() + " items");
		npad.showItems();
		System.out.println();
		System.out.println(rizka.getName() + " items");
		rizka.showItems();
		System.out.println();

		Player winner = null;

		// As long as one of them still alive or winner is still null, go on!
		while (npad.getHealth() > 0 && rizka.getHealth() > 0 && winner == null)
		{
			Player source = null, target = null;

			if (npadChance >= rng.nextDouble())
			{
				// AuahDark turn
				source = npad;
				target = rizka;
			}
			else
			{
				// Amika turn
				source = rizka;
				target = npad;
			}

			boolean takenAction = false;

			// Player chance. Check health.
			if (rng.nextDouble() >= source.getHealth() / 200.0)
			{
				// Use healing items. Search for it.
				for (Item item: source.getItems())
				{
					if (item.getName().indexOf("HP Restorator") == 0)
					{
						item.use();
						takenAction = true;
						break;
					}
				}
			}

			if (takenAction == false)
			{
				// Check energy
				if (source.getEnergy() < 5.0)
				{
					// Use energy items. Search for it.
					for (Item item: source.getItems())
					{
						if (item.getName().indexOf("Energy Restorator") == 0)
						{
							item.use();
							takenAction = true;
							break;
						}
					}
				}
			}

			if (takenAction == false && source.getEnergy() < 5.0)
			{
				// Player lose
				System.out.println(source.getName() + " running out of energy and have no Energy Restorator item!");
				winner = target;
				break;
			}

			// Attack
			source.attack(target);
			System.out.println("- " + source.getName() + " has " + source.getEnergy() + " energy remaining.");
			System.out.println("- " + target.getName() + " has " + target.getHealth() + " HP remaining.");
		}

		if (winner == null)
			winner = npad.getHealth() > 0 ? npad : rizka;
		
		System.out.println(winner.getName() + " wins");
	}

	private static void items(Player npad, Player rizka)
	{
		// Buy/sell items
		// First, let's add some items to AuahDark
		Item sandwich = null;
		npad.addItem(new Item("LP-2.1", "Light Photon. Pink colored, long photon.", 0));
		npad.addItem(sandwich = new Item("Sandwich", "A simple lunch for travels. Heals 15% of max HP", 1000)); // cc reference

		// And to Amika
		rizka.addItem(new Item("LP-2.0", "Light Photon. Pink colored, short photon", 0));
		rizka.addItem(new Item("LP-2.0", "Light Photon. Pink colored, short photon", 0));
		rizka.addItem(new Item("HL-2", "Basic laser handgun. Output pink colored laser", 0));

		// Dialogue 1: AuahDark sells Sandwich
		System.out.println("AuahDark Items Checklist (1)");
		System.out.println(npad.getName() + " items");
		npad.showItems();
		System.out.println();
		System.out.println("AuahDark: So I have this sandwich. How much it will cost?");
		System.out.println("Merchant: Umm... Wait. This item comes from CrossCode right?");
		System.out.println("AuahDark: I have no idea. Anyway how much you'll buy it?");
		System.out.println("Merchant: 1000");
		System.out.println("AuahDark: Deal!");
		sandwich.sell();
		npad.showStatus();
		System.out.println();
		System.out.println("AuahDark Items Checklist (2)");
		System.out.println(npad.getName() + " items");
		npad.showItems();
		System.out.println();

		// Dialogue 2: Amika getting some ammo for her gun.
		System.out.println("Amika Items Checklist (1)");
		System.out.println(rizka.getName() + " items");
		rizka.showItems();
		System.out.println();
		System.out.println("Amika: Hello, I'm looking for ammo for my laser handgun. Do you have any?");
		System.out.println("Merchant: Yes. This ammo pack exactly suits your handgun laser.");
		System.out.println("Amika: How much did it cost?");
		System.out.println("Merchant: Everything.");
		System.out.println("Merchant: Just kidding, I'm not Thanos. It's 2000 for 100 magazines.");
		System.out.println("Amika: Sounds like a big deal.");
		rizka.buy(new Item("HL AP 100mag", "100 magazines of handgun laser ammo.", 2000));
		System.out.println();
		System.out.println("Amika Items Checklist (2)");
		System.out.println(rizka.getName() + " items");
		rizka.showItems();
		System.out.println();
	}
}
