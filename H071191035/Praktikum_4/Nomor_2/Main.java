/**
 * Main Nomor 2
 */
public class Main {

    public static void main(String[] args) {
        
        UKM anggotaInti = new PengurusInti("Ketua Umum", "Sekretaris Umum");
        UKM anggotaKord1 = new KordBidangStaff("Ketua Koordinator Bidang & Staff", "Sekretaris Koordinator Bidang & Staff");

        anggotaInti.rapat();
        anggotaKord1.rapat();

    }

}