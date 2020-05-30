public class Mahasiswa extends SistemInformasi implements User {
    private double nilaiAkhir;
    String name;
    private String nim;

    @Override
    public String UserName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public void MataKuliah(String matkul, int sks) {
        // TODO Auto-generated method stub
        System.out.println("Mata Kuliah\t: " + matkul);
        System.out.println("SKS\t\t: "+ sks);
    }
    public void LectureName(String name) {
        System.out.println("Dosen\t\t: " + name);
    }

    public String nim(String nim) {
        this.nim = nim;
        return nim;
    }

    public double getNilaiAkhir(double nilaiUTS, double nilaiUAS) {
        this.nilaiAkhir = (nilaiUTS + nilaiUAS)/2;
        return nilaiAkhir;
    }
    public void angkaMutu() {
        if (this.nilaiAkhir >= 80) {
            System.out.println("Angka Mutu\t: A");
        } else {
            System.out.println("Angka Mutu\t: E");
        }
    }

    @Override
    public void getUserInfo() {
        // TODO Auto-generated method stub
        System.out.println("Mahasiswa Info");
        System.out.println("==================================================\n");
        System.out.println("Nim\t\t: " + nim);
        System.out.println("Nama\t\t: " + name);
    }
}