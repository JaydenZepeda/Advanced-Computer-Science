public class Hawk {
    private double wingLength;
    private double talonLength;
    private String mainColor;
    private int viewDistance;
    private boolean hasNest;
    private double age;
    private double weight;
    private boolean isHungry;
    private String spieces;
    private String sex;
    private int speed;
    private String location;

    public Hawk(double wingLength, double talonLength, String mainColor, int viewDistance, boolean hasNest, double age,
            double weight, boolean isHungry, String spieces, String sex, int speed, String location) {
        this.wingLength = wingLength;
        this.talonLength = talonLength;
        this.mainColor = mainColor;
        this.viewDistance = viewDistance;
        this.hasNest = hasNest;
        this.age = age;
        this.weight = weight;
        this.isHungry = isHungry;
        this.spieces = spieces;
        this.sex = sex;
        this.speed = speed;
        this.location = location;
    }

    public double getWingLength() {
        return wingLength;
    }

    public void setWingLength(double wingLength) {
        this.wingLength = wingLength;
    }

    public double getTalonLength() {
        return talonLength;
    }

    public void setTalonLength(double talonLength) {
        this.talonLength = talonLength;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public void setViewDistance(int viewDistance) {
        this.viewDistance = viewDistance;
    }

    public boolean isHasNest() {
        return hasNest;
    }

    public void setHasNest(boolean hasNest) {
        this.hasNest = hasNest;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public String getSpieces() {
        return spieces;
    }

    public void setSpieces(String spieces) {
        this.spieces = spieces;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
