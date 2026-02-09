public class Raccoon extends Animal {

    private double age;
    private String location;
    public double weight;

    public Raccoon(double age, String location, double weight, double age2, String location2, double weight2) {
        super(age, location, weight);
        age = age2;
        location = location2;
        weight = weight2;
    }

    public void move() {

    }
}
