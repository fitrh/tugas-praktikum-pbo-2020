
class Tabung extends BangunRuang {
    public int r,t;

    @Override
    public double luasPermukaan() {
        return ((2 * Math.PI * r * r) + (2 * Math.PI * r * t));
    }
    @Override
    public double volume() {
        return  (Math.PI * r * r * t);
    }
}