public class Square extends Rectangle {
    public Square(double sideLength) {
        super(sideLength, sideLength);
    }

    public Square() {
        this(4);
    }

    public String toString() {
        super.toString();
        return "It is also a square.";
    }
}
