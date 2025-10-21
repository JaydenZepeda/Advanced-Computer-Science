public class PawesomeUtils {
    public static char generateDogChar(int dogId) {
        int num = dogId % 10;
        int num2 = ((int) (dogId / 10)) % 10;
        int num3 = ((int) (dogId / 100)) % 10;
        char dogChar = ((char) ('F' + ((num + num2 + num3) % 10)));
        return dogChar;
    }

    public static String pickup(Dog dog, String personName) {
        if (dog.getOwnerName().equals(personName)) {
            dog.setStillInFacility(false);
            return dog.getName() + " has been picked up by their owner " + dog.getOwnerName() + ".";
        }
        return dog.getName() + "'s owner's name does not maatch your name " + personName + ".";
    }

    public static String checkIn(Dog dog, String personName) {
        if (validateDogTag(dog) == true) {
            dog.setStillInFacility(true);
            dog.setOwnerName(personName);
            return "Your dog has been checked in";
        }
        return "Your dog has been denied";
    }

    public static String generateDogTag(int dogId, char dogChar) {
        return "" + dogId + dogChar;
    }
    
    public static int validateDogId(int dogId) {
        String tempId = "" + dogId;
        if (tempId.length() == 3 
            && tempId.charAt(0) != 0) {
            return dogId;
        }
        return (int) ((Math.random() * 900) + 100);
    }

    public static boolean validateDogTag(Dog dog) {
        int validatedDogId = validateDogId(dog.getDogId());
        char tempChar = PawesomeUtils.generateDogChar(validatedDogId);
        String newDogTag = "" + validatedDogId + tempChar;
        if (newDogTag.equals(dog.getDogTag())) {
            return true;
        }
        return false;
    }

    public static int convertAgeToHumanAge(Dog dog) {
        if (dog.getAge() == 1) {
            return 15;
        }   else if (dog.getAge() == 2) {
            return 24;
        } else {
            return (dog.getAge() - 2) * 5 + 24;
        }
    }

    public static int convertAgeToDogYears(int humanYears) {
        if (humanYears <= 15) {
            return 1;
        }   else if (humanYears >= 15 && humanYears <= 24) {
            return 2;
        } else {
            return (humanYears - 24) / 5 + 2;
        }
    }
}
    