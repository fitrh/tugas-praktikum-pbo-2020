/**
 * Main Nomor 1
 */
class Main {

    static void main(String[] args) {
        
        // bangun datar
        BangunDatar persegi = new Persegi(2);
        BangunDatar persegiPanjang = new PersegiPanjang(2, 2);
        BangunDatar lingkaran = new Lingkaran(2);
        BangunDatar segitiga = new Segitiga(2, 2, 2, 2, 2);
        BangunDatar trapesium = new Trapesium(2, 2, 2, 2, 2);

        // bangun ruang
        BangunRuang kubus = new Kubus(2);
        BangunRuang balok = new Balok(2, 2, 2);
        BangunRuang prismaSegitiga = new PrismaSegitiga(2, 2, 2);
        BangunRuang tabung = new Tabung(2, 2);
        BangunRuang bola = new Bola(2);

        // persegi
        System.out.println("Persegi");
        System.out.println("Keliling : " + persegi.getKeliling());
        System.out.println("Luas     : " + persegi.getLuas());
        System.out.println();

        // persegi panjang
        System.out.println("Persegi Panjang");
        System.out.println("Keliling : " + persegiPanjang.getKeliling());
        System.out.println("Luas     : " + persegiPanjang.getLuas());
        System.out.println();

        // lingkaran
        System.out.println("Lingkaran");
        System.out.printf("Keliling : %.2f\n", lingkaran.getKeliling());
        System.out.printf("Luas     : %.2f\n", lingkaran.getLuas());
        System.out.println();

        // segitiga
        System.out.println("Segitiga");
        System.out.println("Keliling : " + segitiga.getKeliling());
        System.out.println("Luas     : " + segitiga.getLuas());
        System.out.println();

        // trapesium
        System.out.println("Trapesium");
        System.out.println("Keliling : " + trapesium.getKeliling());
        System.out.println("Luas     : " + trapesium.getLuas());
        System.out.println();

        // kubus
        System.out.println("Kubus");
        System.out.println("Volume : " + kubus.getVolume());
        System.out.println();

        // balok
        System.out.println("Balok");
        System.out.println("Volume : " + balok.getVolume());
        System.out.println();

        // prisma segitiga
        System.out.println("Prisma Segitiga");
        System.out.println("Volume : " + prismaSegitiga.getVolume());
        System.out.println();

        // tabung
        System.out.println("Tabung");
        System.out.printf("Volume : %.2f\n", tabung.getVolume());
        System.out.println();

        // bola
        System.out.println("Bola");
        System.out.printf("Volume : %.2f\n", bola.getVolume());
        System.out.println();
    }

}