/**
 * UKM
 */
public class UKM {

    protected String ketua;
    protected String sekretaris;

    UKM() {
        ketua = "Belum terpilih";
        sekretaris = "Belum terpilih";
    }
    
    UKM(String ketua, String sekretaris) {
        this.ketua = ketua;
        this.sekretaris = sekretaris;
    }

    protected void rapat() {
        System.out.printf("Rapat oleh %s bersama %s\n\n", ketua, sekretaris);
    }

}