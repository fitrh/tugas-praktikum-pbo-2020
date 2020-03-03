class Player
{
	private String name;
	private int hp, attackPower, defense;

	public Player(String name, int defense)
	{
		this.name = name;
		this.defense = defense;
		hp = 100;
	}

	public Player(String name, int attackPower, int defense)
	{
		this(name, defense);
		this.attackPower = attackPower;
	}

	public void getDemage(Player enemy)
	{
		//hp = hp - (defense - enemy.getAttackPower());
		// Kak Fitrah: Dibalik, enemy.getAttachPower() - defense
		hp = hp - (enemy.getAttackPower() - defense);
	}

	public void status()
	{
		System.out.println(name + " status");
		System.out.println("HP = " + hp);
		System.out.println("Defense = " + defense);
		System.out.println("Attack = " + attackPower);
	}

	public int getAttackPower()
	{
		return attackPower;
	}

	public void setAttackPower(int attackPower)
	{
		this.attackPower = attackPower;
	}
}
