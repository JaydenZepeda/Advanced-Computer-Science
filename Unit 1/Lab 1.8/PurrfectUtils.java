public class PurrfectUtils {
    public static String determineCatMood(Cat cat) {
        if (cat.getMoodLevel() > 7
            && cat.getMoodLevel() <= 10) {
                return "Currently, Cookie is in a great mood.\nPetting is appreciated.";
            } else if (cat.getMoodLevel() > 3
                && cat.getMoodLevel() <= 7) {
                    return "Currently, Cookie is reminiscing of a past life.\n"
                    + "Petting is acceptable.";
                }
        return "Currently, Cookie is plotting revengeance.\nPetting is extremely risky.";
    }

    public static char generateCatChar(String catId) {
        int length = catId.length();
        int total = 0;
        int x = 1;
        for (int i = 0; i < (length); i ++) {
            int id = Integer.valueOf(catId);
            int num = ((id / x) % 10);
            total += num;
            x = x * 10;
            System.out.println(num);
        } 
        System.out.println(total);
        char catChar = ((char) ('A' + ((total) % 26)));
        return catChar;
    }

    public static int generateRandomNumber(int low, int high) {
        int templow = low;
        int temphigh = high;
        if (low > high) {
            low = temphigh;
            high = templow;
        }
        int num = (int) ((Math.random() * (high - low)) + low);
        return num;
    }
    
    public static String validateCatId(String catId) {
        if (Integer.parseInt(catId) > 9999 || Integer.parseInt(catId) < 1000) {
            int num = PurrfectUtils.generateRandomNumber(1000, 10000);
            return String.valueOf(num);
        }
        return catId;
    }

    public static int validateMoodLevel(int moodLevel) {
        if (moodLevel > 10) {
            return 10;
        } else if (moodLevel < 0) {
            return 0;
        }
        return moodLevel;
    }

    public static void bootUp(Cat cat) {
        System.out.println(cat.toString());
    }

    public static void pet(Cat cat) {
        System.out.println("Attempting to pet...");
        if (cat.getMoodLevel() >= 2) {
            cat.setMoodLevel(cat.getMoodLevel() + 1);
            System.out.println("Petting succesful!");
        } else if (cat.getMoodLevel() < 2 && cat.isHungry()) {
            cat.setMoodLevel(cat.getMoodLevel() - 1);
            System.out.println("Petting failed...");
        } else if (cat.getMoodLevel() < 2 && cat.isHungry() == false) {
            cat.setMoodLevel(cat.getMoodLevel() + 1);
            System.out.println("Petting succesful!");  
        }
    }

    public static void trimClaws(Cat cat) {
        System.out.println("Attempting to trim claws...");
        int num = PurrfectUtils.generateRandomNumber(1,3);
        if (num == 1) {
            cat.setMoodLevel(cat.getMoodLevel() - 1);
            System.out.println(cat.getName() + " did not like that...");
        } else {
            cat.setMoodLevel(cat.getMoodLevel() - 2);
            System.out.println(cat.getName() + " really hated that!");
        }
    }

    public static void cleanLitterBox(Cat cat) {
        cat.setHungry(true);
        cat.setMoodLevel(cat.getMoodLevel() + 1);
        System.out.println("Cleaning the litter box...\nDone!\n"
        + cat.getName() + " appreciated that.");
    }

    public static void feed(Cat cat) {
        cat.setHungry(false);
        cat.setMoodLevel(cat.getMoodLevel() + 2);
        System.out.println("Filling up " + cat.getName() + "'s bowl...\nDone!\n" + cat.getName()
        +  " is eating...\n" + cat.getName() + " is full!");
    }
}