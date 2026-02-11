public class Triangle extends Polygon {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super(3);
        this.base = base;
        this.height = height;
    }

    public Triangle() {
        this(3, 4);
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public String toString() {
        super.toString();
        String l1 = "It is a triangle with a base of " + base + " and height of ";
        return l1 + height + ". Its area is " + getArea() + ".";
    }
}
