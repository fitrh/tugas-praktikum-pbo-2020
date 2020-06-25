/**
 * Tabung
 */
class Tabung extends BangunRuang {

    private double radius, tinggi;

    Tabung() {
        radius = 0;
        tinggi = 0;
    }

    Tabung(double radius, double tinggi) {
        this.radius = radius;
        this.tinggi = tinggi;
    }

    @Override
    protected double getVolume() {
        super.volume = Math.PI * Math.pow(radius, 2) * tinggi;
        return super.getVolume();
    }

}