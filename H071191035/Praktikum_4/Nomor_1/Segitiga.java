/**
 * Segitiga
 */
public class Segitiga extends BangunDatar {

    private double sisi1, sisi2, sisi3;
    private double alas;
    private double tinggi;

    Segitiga() {
        alas = 0;
        tinggi = 0;
        sisi1 = 0;
        sisi2 = 0;
        sisi3 = 0;
    }

    Segitiga(double alas, double tinggi, double sisi1, double sisi2, double sisi3) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
    }

    @Override
    protected double getLuas() {
        super.luas = 0.5 * alas * tinggi;
        return super.getLuas();
    }

    @Override
    protected double getKeliling() {
        super.keliling = sisi1 + sisi2 + sisi3;
        return super.getKeliling();
    }

}