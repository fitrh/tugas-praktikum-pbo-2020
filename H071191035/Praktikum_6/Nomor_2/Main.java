package Nomor_2;

public class Main {
    public static void main(String[] args) {
        AcademicInfo academicInfo = new ReportCard();
        System.out.println();
        System.out.println("Academic Information");
        System.out.println("--------------------------------");
        System.out.printf("Student ID       : %s\n", academicInfo.getStudentId());
        System.out.printf("Student Name     : %s\n", academicInfo.getName());
        System.out.printf("Course           : %s\n", academicInfo.getCourse());
        System.out.printf("Class            : %s\n", academicInfo.getClassName());
        System.out.printf("Credits          : %s\n", academicInfo.getCredits());
        System.out.printf("Lecturer(s)      : %s\n", academicInfo.getLecturer());
        System.out.printf("Mid Test Score   : %s\n", academicInfo.getScores(0));
        System.out.printf("Final Test Score : %s\n", academicInfo.getScores(1));
        System.out.printf("Final Score      : %s\n", academicInfo.getScores(2));
        System.out.printf("Grade            : %s\n", academicInfo.getGrade());
        System.out.println("--------------------------------");
    }
}