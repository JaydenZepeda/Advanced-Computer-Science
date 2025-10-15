public class Dog {
    private String name;
    private String ownerName;
    private int age;
    private int dogId;
    private char dogChar;
    private String dogTag;
    private boolean stillInFacility;

    public Dog(String name, String ownerName, int age, int dogId) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.dogId = PawesomeUtils.validateDogId(dogId);
        this.dogChar = PawesomeUtils.generateDogChar(this.dogId);
        this.dogTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
        this.stillInFacility = true;
    }

    public Dog() {
        this.name = "Max";
        this.ownerName = "Theiss";
        this.age = 10;
        this.dogId = 123;
        this.dogChar = PawesomeUtils.generateDogChar(this.dogId);
        this.dogTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
        this.stillInFacility = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public char getDogChar() {
        return dogChar;
    }

    public void setDogChar(char dogChar) {
        this.dogChar = PawesomeUtils.generateDogChar(this.dogId);
    }

    public String getDogTag() {
        return dogTag;
    }

    public void setDogTag(String dogTag) {
        this.dogTag = PawesomeUtils.generateDogTag(this.dogId, this.dogChar);
    }

    public boolean isStillInFacility() {
        return stillInFacility;
    }

    public void setStillInFacility(boolean stillInFacility) {
       this.stillInFacility = stillInFacility;
    }

    public String toString() {
        if (stillInFacility == true) {
            return name + " is good dog. They are " + age + " years old and belong to " +
            ownerName + ". They are currently in our facility. For employee use only: DogTag is " + 
            dogTag + ".";
        }
        return name + " is good dog. They are " + age + " years old and belong to " +
            ownerName + ". They are not currently in our facility. For employee use only: DogTag is " + 
            dogTag + ".";
    }

    public boolean equals(Dog other) {
        if (toString().equals(other.toString())) {
            return true;
          } 
        return false;
    }
}