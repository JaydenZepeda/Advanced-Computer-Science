public class PurrfectUtils {
    public static String determineCatMood(Cat cat) {
        if (Cat.getMoodLevel() > 7
            && Cat.getMoodLevel() <= 10) {
                return "Currently, Cookie is in a great mood.\nPetting is appreciated."
            } else if (Cat.getMoodLevel() > 3
                && Cat.getMoodLevel() <= 7) {
                    return "Currently, Cookie is reminiscing of a past life.\n"
                    + "Petting is acceptable."
                }
        return "Currently, Cookie is plotting revengeance.\nPetting is extremely risky."
    }

    public static char generateCatChar(String catId) {
        int length = catId.length();
        int total = 0;
        int x = 1;
        for (int i = 0; i < length; i ++) {
            int num = ((int) (catId / x)) % 10;
            x = x * 10;
            total += num;
        }
        char catChar = ((char) ('F' + ((total) % 10)));
    }
}
