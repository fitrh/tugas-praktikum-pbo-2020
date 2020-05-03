package Nomor_2;

import java.util.Scanner;

public class ReportCard implements AcademicInfo {
    private String name;
    private String studentId;
    private String className;
    private String course;
    private int credits;
    private String lecturer;
    private double[] scores;
    private boolean validScore = true;

    ReportCard() {
        this.scores = new double[3];
        Scanner input = new Scanner(System.in);
        System.out.print("Name : ");
        this.name = input.nextLine();
        System.out.print("NIM : ");
        this.studentId = input.nextLine();
        System.out.print("Class : ");
        this.className = input.nextLine();
        System.out.print("Course : ");
        this.course = input.nextLine();
        System.out.print("Mid Test Score : ");
        this.scores[0] = input.nextInt();
        System.out.print("Final Test Score : ");
        this.scores[1] = input.nextInt();

        Database database = new Database();
        try {
            this.credits = database.getCredits(this.course);
            this.lecturer = database.getLecturer(this.course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.scores[0] < 0 || this.scores[0] > 100 || this.scores[1]<0 || this.scores[1]>100) {
            this.scores[0] = -1;
            this.scores[1] = -1;
            this.scores[2] = -1;
            this.validScore = false;
        } else {
            this.scores[2] = (this.scores[0] + this.scores[1])/2;
        }

        String grade = convertScore(this.scores[2]);
    }

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getClassName() {
		return this.className;
	}

	@Override
	public String getStudentId() {
		return this.studentId;
	}

	@Override
	public String getCourse() {
		return this.course;
	}

	@Override
	public String getCredits() {
		return this.credits > 0 ? Integer.toString(this.credits) : "Not Available";
	}

	@Override
	public String getLecturer() {
        return this.lecturer != null ? this.lecturer : "Not Available";
	}

	@Override
	public String getGrade() {
		return this.scores[2] != -1 ? convertScore(this.scores[2]) :  "Not Available";
	}

	@Override
	public String convertScore(double score) {
		if (score > 85) {
            return "A";
        } else if (score >= 81) {
            return "A-";
        } else if (score >= 76) {
            return "B+";
        } else if (score >= 71) {
            return "B";
        } else if (score >= 66) {
            return "B-";
        } else if (score >= 61) {
            return "C+";
        } else if (score >= 51) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else if (score < 0) {
            return "Not Available";
        } else {
            return "E";
        }
	}

	@Override
	public String getScores(int index) {
		return this.validScore ? Double.toString(this.scores[index]) : "Invalid Score Range!";
	}
    
}