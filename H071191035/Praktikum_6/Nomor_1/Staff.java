package Nomor_1;

public class Staff extends Employee {

    private int attendance;

    Staff(String name, int attendance) {
        super(name);
        this.attendance = attendance;
    }
    
    @Override
    String getName() {
        return this.name;
    }

    @Override
    int getSalary() {
        return mainSalary + (this.attendance * 50000);
    }

}