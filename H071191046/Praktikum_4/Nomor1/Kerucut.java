
class Kerucut extends BangunRuang{
    public int r,garisPelukis,t;

    @Override
    public double luasPermukaan(){
        return  ((Math.PI * r * r) + (Math.PI * r * garisPelukis));
    }
    @Override
    public double volume() {
        return ((Math.PI * r * r * t) / 3);
    }
}