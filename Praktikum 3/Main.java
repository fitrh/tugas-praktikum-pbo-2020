import java.util.Random;

class Main
{
	public static void main(String[] args) 
	{
		Player p1 = new Player("Player1", "Fighter");
		p1.healing(400.0);
		p1.setLevel(38);
		p1.setDamage(15.0);

		Player p2 = new Player("Player2", "Fighter");
		p2.healing(400.0);
		p2.setLevel(36);
		p2.setDamage(12.0);

		Random rng = new Random();

		p1.showStatus();
		System.out.println();
		p2.showStatus();
		System.out.println();

		// Buy items or fight?
		if (rng.nextDouble() >= 0.5)
			fight(rng, p1, p2);
		else
			items(p1, p2);
	}

	private static void fight(Random rng, Player p1, Player p2)
	{
		double p1Chance = 12.0 / (15.0 + 12.0);

		// Some dialogues and stuff
		// and spoiler for my game storyline
		System.out.println("AS-S3");
		System.out.println("Player1: Uh, what happend to everyone?");
		System.out.println("Player2: Player1, why we meet here? Also what happend to everyone?");
		System.out.println("Player1: Looks like our genetics can resist something.");
		System.out.println("Player2: Yeah. What about we resume our fight which was interrupted before?");
		System.out.println("Player1: Maybe, that's a good idea.");
		System.out.println();

		// Let's add 10 item that restores 50 HP and 5 item that restores 50 Energy for each
		for (int i = 0; i < 10; i++)
		{
			p1.addItem(new Item("HP Restorator Fifties", "Made in Utpala Industries. Restores 50 HP!", 0));
			p2.addItem(new Item("HP Restorator Fifties", "Made in Utpala Industries. Restores 50 HP!", 0));
		}
		for (int i = 0; i < 5; i++)
		{
			p1.addItem(new Item("Energy Restorator Fifties", "Made in Utpala Industries. Restores 50 energy!", 0));
			p2.addItem(new Item("Energy Restorator Fifties", "Made in Utpala Industries. Restores 50 energy!", 0));
		}

		// Items checklist
		System.out.println("Items Checklist");
		System.out.println(p1.getName() + " items");
		p1.showItems();
		System.out.println();
		System.out.println(p2.getName() + " items");
		p2.showItems();
		System.out.println();

		Player winner = null;

		// As long as one of them still alive or winner is still null, go on!
		while (p1.getHealth() > 0 && p2.getHealth() > 0 && winner == null)
		{
			Player source = null, target = null;

			if (p1Chance >= rng.nextDouble())
			{
				// Player1 turn
				source = p1;
				target = p2;
			}
			else
			{
				// Player2 turn
				source = p2;
				target = p1;
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
			winner = p1.getHealth() > 0 ? p1 : p2;

		System.out.println(winner.getName() + " wins");
	}

	private static void items(Player p1, Player p2)
	{
		// Buy/sell items
		// First, let's add some items to Player1
		Item sandwich = null;
		p1.addItem(new Item("LP-2.1", "Light Photon. Pink colored, long photon.", 0));
		p1.addItem(sandwich = new Item("Sandwich", "A simple lunch for travels. Heals 15% of max HP", 1000)); // cc reference

		// And to Player2
		p2.addItem(new Item("LP-2.0", "Light Photon. Pink colored, short photon", 0));
		p2.addItem(new Item("LP-2.0", "Light Photon. Pink colored, short photon", 0));
		p2.addItem(new Item("HL-2", "Basic laser handgun. Output pink colored laser", 0));

		// Dialogue 1: Player1 sells Sandwich
		System.out.println("Player1 Items Checklist (1)");
		System.out.println(p1.getName() + " items");
		p1.showItems();
		System.out.println();
		System.out.println("Player1: So I have this sandwich. How much it will cost?");
		System.out.println("Merchant: Umm... Wait. This item comes from CrossCode right?");
		System.out.println("Player1: I have no idea. Anyway how much you'll buy it?");
		System.out.println("Merchant: 1000");
		System.out.println("Player1: Deal!");
		sandwich.sell();
		p1.showStatus();
		System.out.println();
		System.out.println("Player1 Items Checklist (2)");
		System.out.println(p1.getName() + " items");
		p1.showItems();
		System.out.println();

		// Dialogue 2: Player2 getting some ammo for her gun.
		System.out.println("Player2 Items Checklist (1)");
		System.out.println(p2.getName() + " items");
		p2.showItems();
		System.out.println();
		System.out.println("Player2: Hello, I'm looking for ammo for my laser handgun. Do you have any?");
		System.out.println("Merchant: Yes. This ammo pack exactly suits your handgun laser.");
		System.out.println("Player2: How much did it cost?");
		System.out.println("Merchant: Everything.");
		System.out.println("Merchant: Just kidding, I'm not Thanos. It's 2000 for 100 magazines.");
		System.out.println("Player2: Sounds like a big deal.");
		p2.buy(new Item("HL AP 100mag", "100 magazines of handgun laser ammo.", 2000));
		System.out.println();
		System.out.println("Player2 Items Checklist (2)");
		System.out.println(p2.getName() + " items");
		p2.showItems();
		System.out.println();
	}
}