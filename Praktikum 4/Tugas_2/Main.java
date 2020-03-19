package Tugas_2;

public class Main {
    public static void main(String[] args) {
        Inti inti1 = new Inti (523,"H071171523","Nurwesi Rina Wahyudiani","Ketua");
        Inti inti2 = new Inti (502,"H071171502","Siti Nur Azizah","Wakil Ketua");

        Koordinator bidang1 = new Koordinator(501,"H071171501", "Iksora", "Ketua Bidang 1");
        Koordinator staff = new Koordinator(510,"H071171510", "Vitalia Eka Wardani G", "Staff BIdang 1");

        Koordinator bidang2 = new Koordinator(518,"H071171518", "Muhammad Taufiq Arifin", "Ketua Bidang 2");
        Koordinator staff1 = new Koordinator(306,"H071171306", "Alexandra Thelzya", "Staff BIdang 2");
        Koordinator staff2 = new Koordinator(307,"H071171307", "Ayu Farah DIba Hamzah", "Staff BIdang 2");

        
        System.out.println("Berikut Daftar Keanggotaan UKM Programmer");
        System.out.println("");
        System.out.println("Anggota Inti");
        System.out.println("");
        inti1.Rincian();
        System.out.println("");
        inti2.Rincian();
        System.out.println("");
        System.out.println("Koordinator Bidang dan Staff");
        System.out.println("");
        bidang1.Rincian();
        System.out.println("");
        staff.Rincian();
        System.out.println("");
        bidang2.Rincian();
        System.out.println("");
        staff1.Rincian();
        System.out.println("");
        staff2.Rincian();
        System.out.println("");
  
  }
}
