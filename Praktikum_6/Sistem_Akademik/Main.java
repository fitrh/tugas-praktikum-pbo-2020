import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner pew = new Scanner(System.in);

    public static void main(String[] args) {
        Mahasiswa student = new Mahasiswa();
        Dosen lecture = new Dosen();

        System.out.print("===============================================");
        System.out.print("=============== Sistem Akademik ===============");
        System.out.println("===============================================\n");

        System.out.print("Input Jumlah Mata Kuliah\t::> ");
        int sum = pew.nextInt();
        String [] addMataKuliah = new String[sum];
        int [] sumSKS = new int[sum];
        for (int i = 0; i < addMataKuliah.length; i++) {
            System.out.print((i+1) + ". Input Mata Kuliah\t::> ");
            pew.nextLine();
           addMataKuliah[i] = pew.nextLine();
           System.out.print("   Input SKS\t\t::> ");
           sumSKS[i] = pew.nextInt();
        }

        System.out.println();
        System.out.println("==================== MENU ===================");
        String nameStud;
        String nim;
        double [] uTS = new double[sum];
        double [] uAS = new double[sum];
        HashMap<String, String> matkul = new HashMap<>();
        HashMap<String, Integer> sks = new HashMap<>();
        String [] lectureName = new String[sum];

        //ADD USER
        System.out.println("ADD USER");
        System.out.println("-----------------Add Dosen-----------------");
        pew.nextLine();
        for (int i = 0; i < addMataKuliah.length; i++) {
            System.out.println(addMataKuliah[i]);
            System.out.print("Nama\t::> ");
            lectureName[i] = pew.nextLine();
            matkul.put(addMataKuliah[i], lectureName[i]);
            sks.put(addMataKuliah[i], sumSKS[i]);
        }
        System.out.println();
        System.out.println("---------------Add Mahasiswa---------------");        
        System.out.print("Nama\t::> ");
        nameStud = pew.nextLine();
        student.UserName(nameStud);
        System.out.print("NIM\t::> ");
        nim = pew.next();
        System.out.println("Daftar Mata Kuliah Anda");
        for (int i = 0; i < addMataKuliah.length; i++) {
            System.out.println((i+1) + ". " + addMataKuliah[i]);
            System.out.print("   Nilai UTS\t::> ");
            uTS[i] = pew.nextDouble();
            System.out.print("   Nilai UAS\t::> ");
            uAS[i] = pew.nextDouble();
        }
        System.out.println();

        //USER DETAIL
        student.UserName(nameStud);
        student.nim(nim);
        System.out.println("USER DETAIL MENU");
        System.out.println("1. Mahasiswa\n2. Dosen\n3. AllUser");
        int n = pew.nextInt();
        switch (n) {
            case 1:
                student.getUserInfo();
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < addMataKuliah.length; i++) {
                    student.MataKuliah(addMataKuliah[i], sumSKS[i]);
                    student.LectureName(matkul.get(addMataKuliah[i]));
                    System.out.println("Nilai UTS\t: " + uTS[i]);
                    System.out.println("Nilai UAS\t: " + uAS[i]);
                    System.out.println("Nilai Akhir\t: " + student.getNilaiAkhir(uTS[i], uAS[i]));
                    student.angkaMutu();
                    System.out.println();
                }
                System.out.println("-----------------------------------------------");
                break;
            case 2:
                for (int i = 0; i < lectureName.length; i++) {
                    lecture.UserName(lectureName[i]);
                    lecture.getUserInfo();
                    System.out.println("-----------------------------------------------");
                    lecture.MataKuliah(addMataKuliah[i], sks.get(addMataKuliah[i]));
                }
            default:
                break;
        }
    }
}