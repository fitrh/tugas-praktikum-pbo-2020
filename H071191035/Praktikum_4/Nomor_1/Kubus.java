/**
 * Kubus
 */
class Kubus extends BangunRuang {

    private double sisi;

    Kubus() {
        sisi = 0;
    }

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    protected double getVolume() {
        super.volume = Math.pow(sisi, 3);
        return super.getVolume();
    }

}