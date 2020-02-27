import java.util.*;
class MainPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        p.name = sc.nextLine();
        p.age = sc.nextInt();
        p.isMale = sc.nextBoolean();

        System.out.println("Nama\t\t : " + p.getName());
        System.out.println("Umur\t\t : " + p.getAge());
        System.out.println("Jenis Kelamin\t : " + p.getGender());
    }
}