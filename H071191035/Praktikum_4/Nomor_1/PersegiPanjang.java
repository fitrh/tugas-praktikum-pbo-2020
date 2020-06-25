/**
 * PersegiPanjang
 */
public class PersegiPanjang extends BangunDatar {

    private double panjang;
    private double lebar;

    PersegiPanjang() {
        panjang = 0;
        lebar = 0;
    }

    PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    protected double getLuas() {
        super.luas = panjang * lebar;
        return super.getLuas();
    }
    
    @Override
    protected double getKeliling() {
        super.keliling = 2 * (panjang + lebar);
        return super.getKeliling();
    }

}