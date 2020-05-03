package Nomor_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        // Staf
        System.out.print("Nama staff ::> ");
        String staffName = scan.next();
        System.out.print("Jumlah kehadiran ::> ");
        int staffAttendance = scan.nextInt();
        Employee emp1 = new Staff(staffName, staffAttendance);

        // Dosen
        System.out.print("Nama dosen ::> ");
        String lecturerName = scan.next();
        System.out.print("Jumlah sks ::> ");
        int lecturerCredit = scan.nextInt();
        Employee emp2 = new Lecturer(lecturerName, lecturerCredit);

        // Pegawai Biasa
        System.out.print("Nama staff ::> ");
        String empName = scan.next();
        Employee emp3 = new Employee(empName);

        System.out.printf("%s mendapatkan gaji Rp. %d\n", emp1.getName(), emp1.getSalary());
        System.out.printf("%s mendapatkan gaji Rp. %d\n", emp2.getName(), emp2.getSalary());
        System.out.printf("%s mendapatkan gaji Rp. %d\n", emp3.getName(), emp3.getSalary());

        scan.close();

    }
}