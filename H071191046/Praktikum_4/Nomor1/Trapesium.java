
class Trapesium extends BangunDatar {
    public int sisi1, sisi2, sisi3, tinggi;

    @Override
    public double luas() {
        return (sisi1+sisi2)*tinggi / 2;
    }
    @Override
    public double keliling() {
        return sisi1+sisi2+sisi3+tinggi;
    }
}