package Praktikum_1;

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.width = 15;
        rec.height = 10;
        System.out.println("Luas = " + rec.getArea());
    }
}