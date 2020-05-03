package Nomor_2;

public interface AcademicInfo {
    public abstract String getName();
    public abstract String getClassName();
    public abstract String getStudentId();
    public abstract String getCourse();
    public abstract String getCredits();
    public abstract String getLecturer();
    public abstract String getGrade();
    public abstract String convertScore(double score);
    public abstract String getScores(int index);
}