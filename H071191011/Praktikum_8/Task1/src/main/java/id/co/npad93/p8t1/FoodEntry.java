package id.co.npad93.p8t1;

class FoodEntry
{
	FoodEntry(String name, int price)
	{
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public int getPrice()
	{
		return price;
	}

	private String name;
	private int price;
}
