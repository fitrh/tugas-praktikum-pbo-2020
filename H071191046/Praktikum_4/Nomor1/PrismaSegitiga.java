
class PrismaSegitiga extends BangunRuang{
    public int tSegitiga, alasSegitiga,tprisma,kAlas;

    @Override
    public double luasPermukaan() {
        return (2*((alasSegitiga*tSegitiga)/2) + (kAlas*tprisma));
    }
    @Override
    public double volume() {
        return ((alasSegitiga*tSegitiga)/2 * tprisma);
    }
}