public class DogTester {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Max", "Maximus", 10, 123);
        Dog dog2 = new Dog();//max, theiss
        Dog dog3 = new Dog("Nate", "Nathan", 12, 123);

        System.out.println(dog1.toString() + dog2.toString() + dog3.toString());
        dog1.setDogId(693);
        dog1.setOwnerName("Jack");
        System.out.println(dog1.toString());

        System.out.println(Dog.generateDogChar(dog1.getDogId()));
        System.out.println(Dog.generateDogChar(dog3.getDogId()));
        System.out.println(PawesomeUtils.generateDogTag(dog1.getDogId(), dog1.getDogChar()) + 
        PawesomeUtils.generateDogTag(dog2.getDogId(), dog2.getDogChar()) + 
        PawesomeUtils.generateDogTag(dog3.getDogId(), dog3.getDogChar()));

        System.out.println(dog1.toString() + dog2.toString() + dog3.toString());

        System.out.println(dog1.equals(dog2));
        dog1.setStillInFacility(true);
        dog2.setStillInFacility(true);
        dog1.setOwnerName("Theiss");
        dog2.setDogId(693);
        System.out.println(dog1.equals(dog2));

        System.out.println(Dog.generateDogChar(123));
        System.out.println(Dog.generateDogChar(456));
        System.out.println(Dog.generateDogChar(789));

        Dog dog4 = new Dog("Max", "Maria", 10, 123);
        System.out.println(Dog.pickup(dog4, "Maria"));
        System.out.println(Dog.pickup(dog4, "John"));

        System.out.println(dog4.isStillInFacility());
        dog4.setStillInFacility(false);
        Dog.checkIn(dog4, "NewOwner");
        System.out.println(dog4.isStillInFacility() + dog4.getOwnerName());
    }
}
