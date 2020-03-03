class Tugas1Main
{
	public static void main(String[] args)
	{
		int defense = 15;
		int attack = 30;
		Player player1 = new Player("Mino", attack, defense);
		Player player2 = new Player("Hilda", defense);

		player2.setAttackPower(35);

		player1.getDemage(player2);
		player2.getDemage(player1);
		player1.status();
		player2.status();
	}
}
