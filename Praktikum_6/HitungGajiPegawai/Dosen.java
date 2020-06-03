
public class Dosen extends Pegawai {
    int fee = 120000;

    @Override
    public void bonus(String name, int value) {
        int total = (value*fee)+gaji;
        System.out.println(name + " mendapatkan gaji Rp. " + total);
    }

}