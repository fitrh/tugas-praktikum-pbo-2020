class Staff extends Anggota {

    public Staff(String nama, String prodi, int angkatan) {
        super(nama, prodi, angkatan);
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }
    public void staff() {
        System.out.println("Data Staff");
    }
    
}