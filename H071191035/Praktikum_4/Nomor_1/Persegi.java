/**
 * Persegi
 */
public class Persegi extends BangunDatar {

    private double sisi;
    
    Persegi() {
        sisi = 0;
    }

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    protected double getLuas() {
        super.luas = Math.pow(sisi, 2);
        return super.getLuas();
    }

    @Override
    protected double getKeliling() {
        super.keliling = 4 * sisi;
        return super.getKeliling();
    }

}