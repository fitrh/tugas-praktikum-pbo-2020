/**
 * Nomor 2
 */
class Rectangle {

    double height;
    double width;
    
    double getArea() {
        return height * width;
    }


    public static void main(String[] args) {
        Rectangle rec = new Rectangle();

        rec.height = 75;
        rec.width = 2;

        System.out.println("Luas = "+ rec.getArea());
    }
}