/**
 * Trapesium
 */
public class Trapesium extends BangunDatar {

    private double sisi1, sisi2, sisi3, sisi4;
    private double tinggi;

    Trapesium() {
        sisi1 = 0;
        sisi2 = 0;
        sisi3 = 0;
        sisi4 = 0;
        tinggi = 0;
    }

    Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }

    @Override
    protected double getLuas() {
        super.luas = 0.5 * (sisi2 + sisi4) * tinggi;
        return super.getLuas();
    }

    @Override
    protected double getKeliling() {
        super.keliling = sisi1 + sisi2 + sisi3 + sisi4;
        return super.getKeliling();
    }
    
}