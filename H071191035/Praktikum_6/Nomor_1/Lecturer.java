package Nomor_1;

public class Lecturer extends Employee {

    private int credit;

    Lecturer(String name, int credit) {
        super(name);
        this.credit = credit;
    }
    
    @Override
    String getName() {
        return this.name;
    }

    @Override
    int getSalary() {
        return mainSalary + (this.credit * 120000);
    }

}