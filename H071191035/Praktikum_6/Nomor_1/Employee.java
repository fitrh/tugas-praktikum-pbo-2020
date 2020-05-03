package Nomor_1;

public class Employee {

    protected String name;
    protected int mainSalary;

    Employee(String name) {
        this.name = name;
        this.mainSalary = 2500000;
    }

    String getName() {
        return name;
    }

    int getSalary() {
        return mainSalary;
    }

}