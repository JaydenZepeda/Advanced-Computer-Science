public class PawesomeUtils {
    
    public static String generateDogTag(int dogId, char dogChar) {
        return "" + dogId + dogChar;
    }
    
    public static int validateDogId(int dogId) {
        String tempId = "" + dogId;
        if (tempId.length() == 3 &&
            tempId.charAt(0) != 0) {
                return dogId;
        }
        return (int) (Math.random() * 1000);
    }

    public static boolean validateDogTag(Dog dog) {
        int tempId = dog.getDogId();
        int validatedDogId = validateDogId(tempId);
        char tempChar = Dog.generateDogChar(validatedDogId);
        String newDogTag = "" + validatedDogId + tempChar;
        if (newDogTag.equals(dog.getDogTag())) {
            return true;
        }
        return false;
    }
}
    