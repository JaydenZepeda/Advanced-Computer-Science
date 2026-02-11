public class Hawk extends Animal {
    private double wingLength;
    private double talonLength;
    private String mainColor;
    private int viewDistance;
    private boolean hasNest;
    private boolean isHungry;
    private String spieces;
    private String sex;
    private int speed;

    public Hawk(double age, String location, double weight, double wingLength) {
        super(age, location, weight);
        this.wingLength = wingLength;
    }

    public Hawk() {

    }

    public Hawk(double wingLength, double talonLength, String mainColor, int viewDistance, boolean hasNest, double age,
            double weight, boolean isHungry, String spieces, String sex, int speed, String location) {
        super(age, location, weight);
        this.wingLength = wingLength;
        this.talonLength = talonLength;
        this.mainColor = mainColor;
        this.viewDistance = viewDistance;
        this.hasNest = hasNest;
        this.isHungry = isHungry;
        this.spieces = spieces;
        this.sex = sex;
        this.speed = speed;

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

    public void move() {

    }

}
