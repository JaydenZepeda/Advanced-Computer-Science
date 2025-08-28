public class Ketchup {

    private String color;// = "Red"
    private double cost; //0.1 cents
    private int weight; //10 grams
    private String brand; //"Monarch"
    private String shape; //"rectangle"

    public Ketchup() {  
        color = "Red";
        cost = 0.1;
        weight = 10;
        brand = "Monarch";
        shape = "rectangle";
    }

    // open
    public void open() {
        shape = "hexagon";
        System.out.println("Your packet is now opened");
        return;
    }

    // change brand
    public void changebrand() {
        cost = 0.2;
        brand = "Hienz";
        System.out.println("Your Ketchup packet brand is now 'Heinz', +0.1 cents ");
        return;
    }

    // smash

    public void smash() {
        weight = 2;
        cost = 0;
        System.out.println("Your packet is now smashed ):");
        return;
    }

    // squirt ketchup

    public void squirtketchup() {
        weight = weight - 1;
        System.out.println("You lost some ketchup" + weight);
        if (weight < 1) {
            System.out.println("You have no more ketchup");
            return;
        }
        
    }

}