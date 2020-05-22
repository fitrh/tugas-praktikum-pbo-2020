
class Persegi extends BangunDatar {
    public int sisi;

    @Override
    public double luas() {
        return sisi*sisi;
    }
    @Override
    public double  keliling() {
        return 4*sisi;
    }
}