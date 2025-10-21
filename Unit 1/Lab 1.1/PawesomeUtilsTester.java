public class PawesomeUtilsTester {
    
    public static void main(String[] args) {
        System.out.println(PawesomeUtils.validateDogId(10000));
        System.out.println(PawesomeUtils.generateDogChar(124));

    Dog dog1 = new Dog("Ben", "Ben Owner", 1, 123);
    Dog dog2 = new Dog("Ben2", "Ben Owner2", 2, 456);
    Dog dog3 = new Dog("Ben3", "Ben Owner3", 5, 789);

    System.out.println(PawesomeUtils.validateDogTag(dog1));
    System.out.println(PawesomeUtils.validateDogTag(dog2));
    System.out.println(PawesomeUtils.validateDogTag(dog3));
    dog1.setDogTag("123Z");
    System.out.println(PawesomeUtils.validateDogTag(dog1));
    System.out.println(PawesomeUtils.convertAgeToHumanAge(dog1));
    System.out.println(PawesomeUtils.convertAgeToHumanAge(dog2));
    System.out.println(PawesomeUtils.convertAgeToHumanAge(dog3));
    System.out.println(PawesomeUtils.convertAgeToDogYears(10));
    System.out.println(PawesomeUtils.convertAgeToDogYears(18));
    System.out.println(PawesomeUtils.convertAgeToDogYears(49));
    dog1.setDogTag("123N");
    System.out.println(dog1.getDogTag());
    System.out.println(PawesomeUtils.validateDogTag(dog1));
    }
}