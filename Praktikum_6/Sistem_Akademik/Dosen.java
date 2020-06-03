import java.util.Collection;

public class Dosen extends SistemInformasi implements User {
    private String name;
    
    @Override
    public String UserName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
        return name;
    }

    @Override
    public void MataKuliah(String matkul, int sks) {
        // TODO Auto-generated method stub
        System.out.println("Mata Kuliah Diampuh\t : " + matkul);
        System.out.println("Jumlah SKS\t : " + sks);
    }

    @Override
    public void getUserInfo() {
        // TODO Auto-generated method stub
        System.out.println("Dosen Info");
        System.out.println("==================================================\n");
        System.out.println("Nama\t\t: " + name);
    }

}