
public class Staf extends Pegawai {
    int fee = 50000;

    @Override
    public void bonus(String name, int value) {
        int total = (value*fee) + gaji;
        System.out.println(name + " mendapatkan gaji Rp. " + total);
        
    }
}