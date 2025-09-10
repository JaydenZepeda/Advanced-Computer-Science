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


    public void setColor(String color) {
        this.color = color;
    }


    public String getColor() {
        return color;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }


    public double getCost() {
        return cost;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getBrand() {
        return brand;
    }


    public void setShape(String shape) {
        this.shape = shape;
    }


    public String getShape() {
        return shape;
    }


    public String toString() {
        return "The properties are" + color + cost + weight + brand + shape;
    }


    public boolean equals(Ketchup anotherKetchup) {
        if (this.cost == anotherKetchup.cost &&
            this.weight == anotherKetchup.weight &&
            this.color.equals(anotherKetchup.color) &&
            this.brand.equals(anotherKetchup.brand) &&
            this.shape.equals(anotherKetchup.shape)
        ) {
                return true;
        }

        return false;
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
// Method header/signature
// public void identifier(paramaters or arguement)       void only if nothing is returned
// modifier type                                         type=what type of thing is being returned
//
// ex. public void drinkMe(double amount){
//     if(amount < weight){
//      weight = weight - amount;
//     }                                                *changes weight of the bootle that this method is called on by subtracting amount from weight
//     else{     
//         print("Not enough fluid");                   *check if amount is < weight if so just subtract all good
//     }                                                *if not print "Not enough fluid!" maybe make this be brand= print("Not enough "+ brand)
//}                                                     *boolean has to be in () for if statment 
//                                                      *= means to change variables   == checks if variables are =