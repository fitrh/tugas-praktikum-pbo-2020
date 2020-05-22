import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Bangun Ruang");
        System.out.println("2. Bangun Datar");
        System.out.print("Pilih : ");
        int pilih = sc.nextInt();
        if(pilih == 1) {
            System.out.println("===1. Bangun Ruang===");
            System.out.println(" 1. Kubus\n 2. Balok\n 3. Prisma Segitiga\n 4. Bola\n 5. Tabung\n 6. Limas\n 7. Kerucut");
            System.out.print("Pilih : ");
            int choose = sc.nextInt();
            if(choose == 1) {
                Kubus kubus = new Kubus();
                System.out.print("Sisi : ");
                kubus.sisi = sc.nextInt();
                System.out.println("Luas Permukaan = " + kubus.luasPermukaan());
                System.out.println("Volume = " + kubus.volume());
            } else if (choose == 2) {
                Balok balok = new Balok();
                System.out.print("Panjang : ");
                balok.p = sc.nextInt();
                System.out.print("Lebar : ");
                balok.l = sc.nextInt();
                System.out.print("Tinggi : ");
                balok.t = sc.nextInt();
                System.out.println("Luas Permukaan = " + balok.luasPermukaan());
                System.out.println("Volume = " + balok.volume());
            } else if (choose == 3) {
                PrismaSegitiga prismaSegitiga = new PrismaSegitiga();
                System.out.print("Tinggi Segitiga : ");
                prismaSegitiga.tSegitiga = sc.nextInt();
                System.out.print("Alas Segitiga : ");
                prismaSegitiga.alasSegitiga = sc.nextInt();
                System.out.print("Keliling Segitiga");
                prismaSegitiga.kAlas = sc.nextInt();
                System.out.print("Tinggi Prisma : ");
                prismaSegitiga.tprisma = sc.nextInt();
                System.out.println("Luas Permukaan = " + prismaSegitiga.luasPermukaan());
                System.out.println("Volume = " + prismaSegitiga.volume());
            } else if (choose == 4) {
                Bola bola = new Bola();
                System.out.print("Jari-jari : ");
                bola.r = sc.nextInt();
                System.out.println("Luas Permukaan = " + bola.luasPermukaan());
                System.out.println("Volume = " + bola.volume());
            } else if (choose == 5) {
                Tabung tabung = new Tabung();
                System.out.print("Jari-jari : ");
                tabung.r = sc.nextInt();
                System.out.print("Tinggi : ");
                tabung.t = sc.nextInt();
                System.out.println("Luas Permukaan = " + tabung.luasPermukaan());
                System.out.println("Volume = " + tabung.volume());
            } else if (choose == 6) {
                Limas limas = new Limas();
                System.out.print("Luas Selimut : ");
                limas.luasSelimut = sc.nextInt();
                System.out.print("Luas Alas : ");
                limas.luasAlas = sc.nextInt();
                System.out.print("Tinggi Limas : ");
                limas.tinggi = sc.nextInt();
                System.out.println("Luas permukaan = " + limas.luasPermukaan());
                System.out.println("Volume = " + limas.volume());
            } else if (choose == 7) {
                Kerucut kerucut = new Kerucut();
                System.out.print("Jari-jari : ");
                kerucut.r = sc.nextInt();
                System.out.print("Garis pelukis : ");
                kerucut.garisPelukis = sc.nextInt();
                System.out.print("Tinggi : ");
                kerucut.t = sc.nextInt();
                System.out.println("Luas Permukaan : " + kerucut.luasPermukaan());
                System.out.println("Volume : " + kerucut.volume());
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        } else if (pilih == 2) {
            System.out.println("===2. Bangun Datar===");
            System.out.println("1. Persegi\n 2. Persegi Panjang\n 3. Lingkaran\n 4. Segitiga\n 5. Trapesium\n 6. Jajargenjang\n 7. Layang-Layang\n 8. Belah Ketupat");
            System.out.print("Pilih : ");
            int pilih2 = sc.nextInt();
            if (pilih2 == 1) {
                Persegi persegi = new Persegi();
                System.out.print("Sisi : ");
                persegi.sisi = sc.nextInt();
                System.out.println("Luas : " + persegi.luas());
                System.out.println("keliling : " + persegi.keliling());
            } else if (pilih2 == 2) {
                PersegiPanjang panjang = new PersegiPanjang();
                System.out.print("Panjang : ");
                panjang.panjang = sc.nextInt();
                System.out.print("Lebar : ");
                panjang.lebar = sc.nextInt();
                System.out.println("Luas : " + panjang.luas());
                System.out.println("Keliling : " + panjang.keliling());
            } else if (pilih2 == 3) {
                Lingkaran lingkaran = new Lingkaran();
                System.out.print("Jari-jari : ");
                lingkaran.r = sc.nextInt();
                System.out.println("Luas : " + lingkaran.luas());
                System.out.println("Keliling : " + lingkaran.keliling());
            } else if (pilih2 == 4) {
                Segitiga segitiga = new Segitiga();
                System.out.print("Alas : ");
                segitiga.alas = sc.nextInt();
                System.out.print("Tinggi : ");
                segitiga.tinggi = sc.nextInt();
                System.out.print("Sisi : ");
                segitiga.sisi = sc.nextInt();
                System.out.println("Luas : " + segitiga.luas());
                System.out.println("Keliling : " + segitiga.keliling());
            } else if (pilih2 == 5) {
                Trapesium trapesium = new Trapesium();
                System.out.print("Sisi 1 :");
                trapesium.sisi1 = sc.nextInt();
                System.out.print("Sisi 2 :");
                trapesium.sisi2 = sc.nextInt();
                System.out.print("Sisi 3 :");
                trapesium.sisi3 = sc.nextInt();
                System.out.println("Tinggi : ");
                trapesium.tinggi = sc.nextInt();
                System.out.println("Luas : " + trapesium.luas());
                System.out.println("Keliling : " + trapesium.keliling());
            } else if (pilih2 == 6) {
                JajarGenjang jGenjang = new JajarGenjang();
                System.out.print("sisi a : ");
                jGenjang.a = sc.nextInt();
                System.out.print("Sisi b :");
                jGenjang.b = sc.nextInt();
                System.out.print("Tinggi : ");
                jGenjang.t = sc.nextInt();
                System.out.println("Luas : " + jGenjang.luas());
                System.out.println("Keliling : " + jGenjang.keliling());
            } else if (pilih2 == 7) {
                LayangLayang layang = new LayangLayang();
                System.out.print("Diagonal 1 :");
                layang.d1 = sc.nextInt();
                System.out.print("Diagonal 2 :");
                layang.d2 = sc.nextInt();
                System.out.print("Sisi Pendek : ");
                layang.sisiPendek = sc.nextInt();
                System.out.print("Sisi Panjang : ");
                layang.sisiPanjang = sc.nextInt();
                System.out.println("Luas : " + layang.luas());
                System.out.println("Keliling : " + layang.keliling());
            } else if (pilih2 == 8) {
                BelahKetupat belahKetupat = new BelahKetupat();
                System.out.print("Diagonal 1 : ");
                belahKetupat.d1 = sc.nextInt();
                System.out.print("Diagonal 2 :");
                belahKetupat.d2 = sc.nextInt();
                System.out.print("Sisi : ");
                belahKetupat.sisi = sc.nextInt();
                System.out.println("Luas : " + belahKetupat.luas());
                System.out.println("Keliling : " + belahKetupat.keliling());
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        } else {
            System.err.println("Pilihan tidak tersedia");
        }
        sc.close();
    }
}