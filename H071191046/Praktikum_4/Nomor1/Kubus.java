
class Kubus extends BangunRuang {
    public int sisi;

    @Override
    public double luasPermukaan() {
        return 6*(sisi*sisi);
    }
    @Override
    public double volume() {
        return sisi*sisi*sisi;
    }

}