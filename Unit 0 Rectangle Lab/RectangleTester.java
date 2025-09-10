public class RectangleTester {
    public static void main(String[] args) {
        
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(20, 10);

        System.out.println(rect1.toString());
        System.out.println(rect2.toString());
        rect1.setLength(20);
        rect1.setWidth(10);
        System.out.println(rect1.toString());
        System.out.println(rect2.toString());
        System.out.println(rect1.equals(rect2));
        System.out.println(rect1.calculateDiagonal());
    }
    
}
