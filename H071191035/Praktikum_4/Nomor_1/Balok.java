/**
 * Kubus
 */
class Balok extends BangunRuang {

    private double panjang, lebar, tinggi;

    Balok() {
        panjang = 0;
        lebar = 0;
        tinggi = 0;
    }

    Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    @Override
    protected double getVolume() {
        super.volume = panjang * lebar * tinggi;
        return super.getVolume();
    }

}