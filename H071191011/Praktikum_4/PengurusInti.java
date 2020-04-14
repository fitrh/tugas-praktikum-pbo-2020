class PengurusInti extends Anggota
{
	private PengurusInti(String name, String role)
	{
		super(name, role);
	}

	public static PengurusInti newLeader(String name)
	{
		return new PengurusInti(name, "Ketua");
	}

	public static PengurusInti newSecretary(String name)
	{
		return new PengurusInti(name, "Sekretaris");
	}
}
