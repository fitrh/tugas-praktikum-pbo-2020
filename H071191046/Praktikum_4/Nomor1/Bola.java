
class Bola extends BangunRuang {
    public int r;

    @Override
    public double luasPermukaan() {
        return  (4 * Math.PI * r * r);
    }
    @Override
    public double volume() {
        return  ((4 * Math.PI * r * r * r) / 3);
    }
}