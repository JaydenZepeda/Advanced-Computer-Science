public class CleanUtils {
    public static int validateCleanlinessLevel(int cleanlinessLevel) {
        if (cleanlinessLevel < 0) {
            return 0;
        } else if (cleanlinessLevel > 10) {
            return 10;
        } else {
            return cleanlinessLevel;
        }
    }

    public static String generateUsername(String name) {
        int num = (int) ((Math.random() * 100) + 1950);
        String username = "@";
        name = name.toLowerCase();
        username += name.substring(0, name.indexOf(" ")) + "_";
        username += name.substring((name.indexOf(" ") + 1)) + "_" + num;
        return username;
    }

    public static void cleanHome(Home home) {
        home.setCleanlinessLevel(home.getCleanlinessLevel() + 2);
    }

    public static String fixName(String name) {
        name = name.trim();
        String first = name.substring(0, name.indexOf(" "));
        String last = name.substring(name.indexOf(" ")).trim();
        return first + " " + last;
    }
}

