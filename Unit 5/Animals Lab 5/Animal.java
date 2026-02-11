public abstract class Animal {
    private double age;
    private String location;
    public double weight;

    public Animal(double age, String location, double weight) {
        this.age = age;
        this.location = location;
        this.weight = weight;
    }

    public Animal() {

    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void ageUp() {
        age++;
    }

    public void ageUp(double delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta must be positive");
        }
        age += age;
    }

    public void gainWeight(double kg) {
        if (kg < 0) {
            throw new IllegalArgumentException("Can't gain negetive weight");
        }
        weight += kg;
    }

    public void loseWeight(double kg) {
        if (weight - kg < 0) {
            throw new IllegalArgumentException("Cannot become negetive weight");
        }
        weight -= kg;
    }

    public abstract void move();

}
