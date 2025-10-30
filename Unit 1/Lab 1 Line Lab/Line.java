public class Line {
    private int a;
    private int b;
    private int c;
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        // instance variables a, b, and c
        // a = - (y2 - y1)
        this.a = -(p2.getY() - p1.getY()); 

        // b = x2 - x1
        this.b = p2.getX() - p1.getX(); 

        // c = - (a * x1 + b * y1)
        this.c = -(this.a * p1.getX() + p1.getY() * this.b); 
    }

    public Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public int getA() {
        return a;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public int getB() {
        return b;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    public int getC() {
        return c;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double calculateSlope() {
        double slope = ((double) (this.a) * -1) / this.b;
        return slope;
    }

    public boolean isCoordinateOnLine(Point p) {
        if (this.a * p.getX() + this.b * p.getY() + this.c == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Equation = " + a + "x + " + b + "y + " + c + " = 0";
    }

    public boolean equals(Line other) {
        if (this.a == other.a
            && this.b == other.b
            && this.c == other.c) {
            return true;    
        }
        return false;
    }

    public double calculateSlopeFromPoints() {
        double slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        return slope;
    }

    public String generatePointSlopeFormula() {
        double m = calculateSlopeFromPoints();
        return "(y - " + p1.getY() + ") = " + m + "(x - "
            + p1.getX() + ")";
    }
    
}
