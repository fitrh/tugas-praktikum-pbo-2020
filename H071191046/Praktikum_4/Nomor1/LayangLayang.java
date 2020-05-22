
class LayangLayang extends BangunDatar {
    public int d1,d2,sisiPendek,sisiPanjang;

    @Override
    public double luas() {
        return (d1*d2)/2;
    }
    @Override
    public double keliling() {
        return 2*(sisiPendek + sisiPanjang);
    }

}