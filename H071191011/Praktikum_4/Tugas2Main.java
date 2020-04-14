class Tugas2Main
{
	public static void main(String[] a)
	{
		System.out.println("UKM Band Hayalan");
		Anggota[] daftarAnggota = {
			PengurusInti.newLeader("Kasumi Toyama"),
			PengurusInti.newSecretary("Arisa Ichigaya"),
			new KoordinatorBidangStaf("Tae Hanazono"),
			new KoordinatorBidangStaf("Rimi Ushigome"),
			new KoordinatorBidangStaf("Saaya Yamabuki")
		};

		for (int i = 0; i < daftarAnggota.length; i++)
		{
			Anggota anggota = daftarAnggota[i];
			System.out.printf("%d. %s\n", i + 1, anggota.getName());
			System.out.println(anggota.getRole());
		}
	}
}
