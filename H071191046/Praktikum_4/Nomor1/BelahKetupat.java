
class BelahKetupat extends BangunDatar {
    public int d1,d2,sisi;

    @Override
    public double luas() {
        return (d1*d2)/2;
    }
    @Override
    public double keliling() {
        return 4*sisi;
    }
}