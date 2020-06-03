package Praktikum_1;

public class PersonMain {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Fauzi Asham");
        person1.setAge(19);
        person1.setGender(true);
        System.out.println("Name\t: " + person1.getName());
        System.out.println("Age\t: "+ person1.getAge());
        System.out.println("Gender\t: " + (person1.getGender() ? "Male" : "Female"));
    }
}