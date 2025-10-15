public class PawesomeUtilsTester {
    
    public static void main(String[] args) {
        System.out.println(PawesomeUtils.validateDogId(10000));
    

    Dog dog1 = new Dog("Ben", "Ben Owner", 5, 123);
    Dog dog2 = new Dog("Ben2", "Ben Owner2", 6, 456);
    Dog dog3 = new Dog("Ben3", "Ben Owner3", 7, 789);

    System.out.println(PawesomeUtils.validateDogTag(dog1));
    System.out.println(PawesomeUtils.validateDogTag(dog2));
    System.out.println(PawesomeUtils.validateDogTag(dog3));
    dog1.setDogTag("123Z");
    System.out.println(PawesomeUtils.validateDogTag(dog1));

    }
}