import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    public MyPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setSize(500, 500);
    }

    public void paint(Graphics g) {
        // to-do: draw the house!

        // Adds shapes to an ArrayList, converting them all to Polygons
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        // building
        shapes.add(new Rectangle(125, 125, 250, 250));// 1
        shapes.get(0).setFillColor(Color.RED);

        // door
        shapes.add(new Rectangle(175, 250, 50, 125));// 2
        shapes.get(1).setFillColor(Color.lightGray);

        // roof
        shapes.add(new Triangle(new int[] { 125, 250, 375 }, new int[] { 125, 75, 125 }));// 3
        (shapes.get(2)).setFillColor(Color.black);
        shapes.add(new Circle(50, 50, 75));// 4
        (shapes.get(3)).setFillColor(255, 255, 0);

        shapes.add(new Circle(55, 100, 25));// 5
        shapes.add(new Circle(65, 90, 25));// 6
        shapes.add(new Circle(75, 100, 25));// 7
        shapes.add(new Circle(85, 90, 25));// 8
        shapes.add(new Circle(95, 100, 25));// 9
        (shapes.get(4)).setFillColor(Color.white);
        (shapes.get(5)).setFillColor(Color.white);
        (shapes.get(6)).setFillColor(Color.white);
        (shapes.get(7)).setFillColor(Color.white);
        (shapes.get(8)).setFillColor(Color.white);
        shapes.add(new Rectangle(400, 175, 50, 200));// 10
        (shapes.get(9)).setFillColor(150, 75, 0);
        shapes.add(new Circle(370, 160, 30));// 11
        shapes.add(new Circle(390, 160, 30));// 12
        shapes.add(new Circle(410, 160, 30));// 13
        shapes.add(new Circle(430, 160, 30));// 14
        shapes.add(new Circle(450, 160, 30));// 15
        shapes.add(new Circle(375, 140, 30));// 16
        shapes.add(new Circle(395, 140, 30));// 17
        shapes.add(new Circle(415, 140, 30));// 18
        shapes.add(new Circle(425, 140, 30));// 19
        shapes.add(new Circle(440, 140, 30));// 20
        shapes.add(new Circle(390, 120, 30));// 21
        shapes.add(new Circle(410, 120, 30));// 22
        shapes.add(new Circle(430, 120, 30));// 23
        (shapes.get(10)).setFillColor(Color.green);
        shapes.get(11).setFillColor(Color.green);
        shapes.get(12).setFillColor(Color.green);
        shapes.get(13).setFillColor(Color.green);
        shapes.get(14).setFillColor(Color.green);
        shapes.get(15).setFillColor(Color.green);
        shapes.get(16).setFillColor(Color.green);
        shapes.get(17).setFillColor(Color.green);
        shapes.get(18).setFillColor(Color.green);
        shapes.get(19).setFillColor(Color.green);
        shapes.get(20).setFillColor(Color.green);
        shapes.get(21).setFillColor(Color.green);
        shapes.get(22).setFillColor(Color.green);
        shapes.add(new Square(300, 200, 20));// 24
        shapes.add(new Square(300, 180, 20));// 25
        shapes.add(new Square(320, 200, 20));// 26
        shapes.add(new Square(320, 180, 20));// 27
        shapes.get(23).setFillColor(Color.white);
        shapes.get(24).setFillColor(Color.white);
        shapes.get(25).setFillColor(Color.white);
        shapes.get(26).setFillColor(Color.white);
        shapes.get(23).setStrokeColor(Color.BLACK);
        shapes.get(24).setStrokeColor(Color.BLACK);
        shapes.get(25).setStrokeColor(Color.BLACK);
        shapes.get(26).setStrokeColor(Color.BLACK);
        shapes.add(new Rectangle(155, 70, 40, 45));
        shapes.get(27).setFillColor(180, 70, 0);

        // Draws all the shapes in the ArrayList using that shape's draw method
        for (Shape p : shapes) {
            p.draw(g);
        }

    }

}
