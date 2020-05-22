
class Limas extends BangunRuang {
    public int luasAlas, luasSelimut, tinggi;

    @Override
    public double luasPermukaan() {
        return luasAlas + luasSelimut;
    }
    @Override
    public double volume() {
        return (luasAlas*tinggi)/3;
    }
}