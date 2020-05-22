
class Balok extends BangunRuang {
    public int p,l,t;

    @Override
    public double luasPermukaan() {
        return 2*(p*l + l*t + p*t);
    }
    @Override
    public double volume() {
        return p*l*t;
    }

}