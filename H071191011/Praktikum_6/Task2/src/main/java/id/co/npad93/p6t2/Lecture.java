package id.co.npad93.p6t2;

class Lecture implements User
{
	Lecture(String name)
	{
		if (name == null)
			throw new NullPointerException("name");

		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	private String name;
}
