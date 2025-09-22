public class Line {
    private int a;
    private int b;
    private int c;

    public Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void seta(int a) {
        this.a = a;
    }
    
    public int geta() {
        return a;
    }

    public void setb(int b) {
        this.b = b;
    }
    
    public int getb() {
        return b;
    }

    public void setc(int c) {
        this.c = c;
    }
    
    public int getc() {
        return c;
    }

    public double calculateSlope() {
        double slope = ((double) (this.a) * -1) / this.b;
        return slope;
    }

    public boolean isCoordinateOnLine(int x, int y) {
        if (this.a * x + this.b * y + this.c == 0) {
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

    
}
