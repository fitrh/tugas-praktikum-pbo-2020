package Praktikum_2;

public class Box {
    private double width;
    private double height;
    private double depth;
    private double mass;
    private double density;

    public Box(double width, double height,  double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public double setWidth(double width) {
        this.width = width;
        return width;
    }
    public double setHeight(double height) {
        this.height = height;
        return height;
    }
    public double setDepth(double depth) {
        this.depth = depth;
        return depth;
    }
    public double setMass(double mass) {
        this.mass = mass;
        return mass;
    }
    public double getDensity() {
        density = mass/(width*height*depth);
        return density;
    }
}