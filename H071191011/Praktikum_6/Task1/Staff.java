// Staf

class Staff extends Employee
{
	Staff(String name, int attendance)
	{
		super(name);
		this.attendance = attendance;
	}

	@Override
	public long getSalary()
	{
		return super.getSalary() + attendance * 50000;
	}

	private int attendance;
}
