/**
 * Lingkaran
 */
public class Lingkaran extends BangunDatar {

    private double radius;

    Lingkaran() {
        radius = 0;
    }

    Lingkaran(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getLuas() {
        super.luas = Math.PI * Math.pow(radius, 2);
        return super.getLuas();
    }

    @Override
    protected double getKeliling() {
        super.keliling = 2 * Math.PI * radius;
        return super.getKeliling();
    }
    
}