class Anggota
{
	// FIXME: I just have no idea how to translate
	// all the class names to English
	protected Anggota(String name, String role)
	{
		this.name = name;
		this.role = role;
	}

	public String getName()
	{
		return name;
	}

	public String getRole()
	{
		return role;
	}

	protected String name, role;
}
