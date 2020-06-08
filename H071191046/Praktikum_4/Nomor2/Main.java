import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SISTEM INFORMASI UKM PROGRAMMER UNHAS");
        System.out.println("1. Pengurus Inti");
        System.out.println("2. Koordinator Bidang");
        System.out.println("3. Staff");
        System.out.print("Data yang ingin ditampilkan : ");
        int pilih = sc.nextInt();
        if(pilih == 1) {
            // System.out.println("Data Pengurus Inti");   
			PengurusInti pInti = new PengurusInti("Sakinah Yunus", "Ilkom", 2018);
            pInti.pengurus();
            pInti.showStatus();
        } else if (pilih == 2) {
            Koordinator koordinator = new Koordinator("Anugrah Lestari", "Teknik Informatika", 2018);
            koordinator.koordinator();
            koordinator.showStatus();
        } else if (pilih == 3) {
            Staff staff = new Staff("Rahmi", "Teknik Informatika",2019);
            staff.staff();
            staff.showStatus();
        }
    }
}