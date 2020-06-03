public abstract class SistemInformasi {
    
    public abstract void getUserInfo();
    public String getAllUser(String User) {
        return User;
    }
    public String getStudent(String Mahasiswa) {
        return Mahasiswa;
    }
    public String getLecture(String Dosen) {
        return Dosen;
    }
}