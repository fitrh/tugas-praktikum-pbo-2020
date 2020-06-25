import java.util.Scanner;
/**
 * Nomor 2
 */
class Box {

    private double width, height, depth, mass, density;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void setWidth(double width) {
        this.width = width;       
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDensity() {
        density = mass / (width * height * depth); 
        return density;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        double width = input.nextDouble();
        double height = input.nextDouble();
        double depth = input.nextDouble();
        double mass = input.nextDouble();

        Box box = new Box(width, height, depth);
        box.setMass(mass);
        System.out.println("Massa jenis = " + box.getDensity());
        box.setMass(mass*2);
        System.out.println("Massa jenis = " + box.getDensity());
        
        input.close();
    }
}