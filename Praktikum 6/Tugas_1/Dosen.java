
package Tugas_1;

class Dosen extends Pegawai{
    private int sks;
    public Dosen(String name, int sks){
        super(name);
        setSks(sks);
    }
    public void setSks(int sks) {
        this.sks = sks;
    }
    public int getSks() {
        return sks;
    }
    @Override
    public int getGaji(){
        return gaji+(sks*120000);
    }
}
