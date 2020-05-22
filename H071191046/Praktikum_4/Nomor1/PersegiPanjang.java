
class PersegiPanjang extends BangunDatar  {
    public int panjang;
    public int lebar;

    @Override
    public double luas() {
        return panjang*lebar;
    }
    @Override
    public double keliling() {
        return 2*(panjang + lebar);
    }
}