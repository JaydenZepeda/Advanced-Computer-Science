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
        this.dogId = dogId;
        this.dogChar = Dog.generateDogChar(this.dogId);
        this.dogTag = generateDogTag();
        this.stillInFacility = true;
    }

    public Dog() {
        this.name = "Max";
        this.ownerName = "Theiss";
        this.age = 10;
        this.dogId = generateDogId();
        this.dogChar = Dog.generateDogChar(this.dogId);
        this.dogTag = generateDogTag();
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
        this.dogChar = Dog.generateDogChar(this.dogId);
    }

    public String getDogTag() {
        return dogTag;
    }

    public void setDogTag(String dogTag) {
        this.dogTag = generateDogTag();
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

    public String generateDogTag() {
        return dogTag = "" + dogId + dogChar;
    }
    
    public int generateDogId() {
        return (int) (Math.random() * 1000);
    }

    public static char generateDogChar(int dogId) {
        int num = dogId % 10;
        int num2 = ((int) (dogId / 10)) % 10;
        int num3 = ((int) (dogId / 100)) % 10;
        char dogChar = ((char) ('F' +((num + num2 + num3) % 10)));
        return dogChar;
    }

    public static String pickup(Dog dog, String personName) {
        if (dog.ownerName.equals(personName)) {
            dog.stillInFacility = false;
            return dog.name + " has been picked up by their owner " + dog.ownerName + ".";
        }
        return dog.name + "'s owner's name does not maatch your name " + personName + ".";
    }

    public static void checkIn(Dog dog, String personName) {
        dog.stillInFacility = true;
        dog.ownerName = personName;
    }
}
