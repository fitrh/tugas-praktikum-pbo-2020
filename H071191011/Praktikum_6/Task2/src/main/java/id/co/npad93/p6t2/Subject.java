package id.co.npad93.p6t2;

class Subject
{
	Subject(String name, int credits, Lecture lecture)
	{
		if (name == null)
			throw new NullPointerException("name");
		if (credits <= 1)
			throw new IllegalArgumentException("credits");
		if (lecture == null)
			throw new NullPointerException("lecture");

		this.name = name;
		this.credits = credits;
		this.lecture = lecture;
	}

	public String getName()
	{
		return name;
	}

	public int getCredits()
	{
		return credits;
	}

	public Lecture getLecture()
	{
		return lecture;
	}

	private String name;
	private int credits;
	private Lecture lecture;
}
