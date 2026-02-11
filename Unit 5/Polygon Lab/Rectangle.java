public class Rectangle extends Polygon {
    private double length;
    private double width;

    public Rectangle(double width, double length) {
        super(4);
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
        this(4, 3);
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        super.toString();
        String l1 = "It is a rectangle with a length of " + length + " and width of ";
        return l1 + width + ". Its area is " + getArea() + ".";
    }
}
