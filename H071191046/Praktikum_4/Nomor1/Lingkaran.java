class Lingkaran extends BangunDatar {
    public int r;

    @Override
    public double luas() {
        return  (Math.PI * r * r);
    }
    @Override
    public double keliling() {
        return (2 * Math.PI * r);
    }
}