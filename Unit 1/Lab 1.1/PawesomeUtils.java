public class PawesomeUtils {
    public static char generateDogChar(int dogId) {
        int num = dogId % 10;
        int num2 = ((int) (dogId / 10)) % 10;
        int num3 = ((int) (dogId / 100)) % 10;
        char dogChar = ((char) ('F' +((num + num2 + num3) % 10)));
        return dogChar;
    }

    public static String pickup(Dog dog, String personName) {
        if (dog.getOwnerName().equals(personName)) {
            dog.setStillInFacility(false);
            return dog.getName() + " has been picked up by their owner " + dog.getOwnerName() + ".";
        }
        return dog.getName() + "'s owner's name does not maatch your name " + personName + ".";
    }

    public static void checkIn(Dog dog, String personName) {
        if () {
            dog.setStillInFacility(true);
            dog.setOwnerName(personName);
        }
    }

    public static String generateDogTag(int dogId, char dogChar) {
        return "" + dogId + dogChar;
    }
    
    public static int validateDogId(int dogId) {
        String tempId = "" + dogId;
        if (tempId.length() == 3 &&
            tempId.charAt(0) != 0) {
                return dogId;
        }
        return (int) ((Math.random() * 900) + 100);
    }

    public static boolean validateDogTag(Dog dog) {
        int tempId = dog.getDogId();
        int validatedDogId = validateDogId(tempId);
        char tempChar = PawesomeUtils.generateDogChar(validatedDogId);
        String newDogTag = "" + validatedDogId + tempChar;
        if (newDogTag.equals(dog.getDogTag())) {
            return true;
        }
        return false;
    }



}
    