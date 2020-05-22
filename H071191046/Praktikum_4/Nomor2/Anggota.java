class Anggota {
    protected String nama;
    protected String prodi;
    // public String jabatan;
    protected int angkatan;

    public Anggota (String nama, String prodi,  int angkatan) {
        this.nama = nama;
        this.prodi = prodi;
        this.angkatan = angkatan;
    }
    public void showStatus() {
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Prodi\t\t: " + prodi);
        System.out.println("Angkatan\t: " + angkatan);
    }
    public void anggota() {
        System.out.println("Anggota UKM Programmer Unhas");
    }
}