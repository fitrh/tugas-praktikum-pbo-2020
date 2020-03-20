/**
 * Bola
 */
class Bola extends BangunRuang {

    private double radius;

    Bola() {
        radius = 0;
    }

    Bola(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        super.volume = 4/3 * Math.PI * Math.pow(radius, 3);
        return super.getVolume();
    }

}