/**
 * PrismaSegitiga
 */
class PrismaSegitiga extends BangunRuang {

    private double alas, tinggi, tinggiPrisma;

    PrismaSegitiga() {
        alas = 0;
        tinggi = 0;
        tinggiPrisma = 0;
    }

    PrismaSegitiga(double alas, double tinggi, double tinggiPrisma) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.tinggiPrisma = tinggiPrisma;
    }
    
    @Override
    protected double getVolume() {
        super.volume = 0.5 * alas * tinggi * tinggiPrisma;
        return super.getVolume();
    }

}