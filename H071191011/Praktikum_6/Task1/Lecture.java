// Dosen

class Lecture extends Employee
{
	Lecture(String name, int credits)
	{
		super(name);
		this.credits = credits;
	}

	@Override
	public long getSalary()
	{
		return super.getSalary() + credits * 120000;
	}

	private int credits;
}
