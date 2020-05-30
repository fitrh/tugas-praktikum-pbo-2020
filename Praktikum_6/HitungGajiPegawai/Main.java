import java.util.Scanner;

public class Main {
    
    static Scanner pew = new Scanner(System.in);
    public static void main(String[] args) {
        Pegawai staf = new Staf();
        Pegawai dosen = new Dosen();
        Pegawai pegawai = new Pegawai();

        System.out.println("============ Hitung Gaji Pegawai ============\n");

        System.out.print("Nama Staf\t\t::>  " );
        String name = pew.next();
        System.out.print("jumlah kehadiran\t::>  ");
        int value = pew.nextInt();

        System.out.print("Nama Dosen\t\t::>  ");
        String nama = pew.next();
        System.out.print("jumlah SKS\t\t::>  ");
        int val = pew.nextInt();
        
        System.out.print("Nama Pegawai\t\t::>  ");
        String name3 = pew.next();

        System.out.println();
        staf.bonus(name, value);
        dosen.bonus(nama, val);
        pegawai.bonus(name3);
        System.out.println("===============================================");
    }
}