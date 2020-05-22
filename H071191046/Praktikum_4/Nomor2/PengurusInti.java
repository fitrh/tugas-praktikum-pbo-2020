class PengurusInti extends Anggota {

    public PengurusInti(String nama, String prodi, int angkatan) {
        super(nama, prodi, angkatan);
        // nama = "Sakinah Yunus";
        // prodi = "Ilmu Komputer";
        // angkatan= 2017;
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }
    public void pengurus() {
        System.out.println("Data Pengurus Inti");
    }
    
}