public class Rectangle {
    private int length;
    private int width;
    
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }


    public Rectangle() {
        length = 10;
        width = 4;
    }


    public void setLength(int length) {
        this.length = length;
    }


    public int getLenth() {
        return length;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getWidth() {
        return width;
    }


    public String toString() {
        return "The width is " + width + " and the length is " + length;
    }


    public boolean equals(Rectangle other) {
        if (this.length == other.length 
            && this.width == other.width
            ) {
            return true;
        }

        return false;
    }


    public int calculateArea() {
        return length * width;
    }


    public int calculatePerimeter() {
        return 2 * (length + width);
    }


    public double calculateDiagonal() {
        return Math.sqrt(length ^ 2 + width ^ 2);
    }
}
