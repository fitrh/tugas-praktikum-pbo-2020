
class Segitiga extends BangunDatar{
    public int alas, tinggi, sisi;

    @Override
    public double luas() {
        return (alas*tinggi)/2;
    }
    @Override
    public double keliling() {
        return alas+tinggi+sisi;
    }
}