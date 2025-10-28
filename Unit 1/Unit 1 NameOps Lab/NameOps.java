public class NameOps {
    public static String printMethodCall(String method, String name) {
        return method + "(\"" + name + "\"): ";  
    }

    public static String whoIsAwesome(String name) {
        return name + " is awesome!";
    }

    public static int indexOfFirstSpace(String name) {
        return name.indexOf(" ");
    }

    public static int indexOfSecondSpace(String name) {
        int firstSpace = indexOfFirstSpace(name);
        if (name.substring(firstSpace + 1).indexOf(" ") > -1) {
            return name.substring(firstSpace + 1).indexOf(" ") + indexOfFirstSpace(name) + 1; 
        } // add one for the 0 not included when 1 added for substring
        return -1;
    }

    public static String findFirstName(String name) {
        if ((indexOfFirstSpace(name)) == -1) {
            return name;
        }
        return name.substring(0, name.indexOf(" "));
    }

    public static String findLastName(String name) {
        if ((indexOfFirstSpace(name)) == -1) {
            return "";
        } else if (((indexOfSecondSpace(name)) == -1)) {
            return name.substring(indexOfFirstSpace(name) + 1);
        }
        return name.substring(indexOfSecondSpace(name) + 1);
    }
    
    public static String findMiddleName(String name) {
        if ((indexOfFirstSpace(name)) == -1 || ((indexOfSecondSpace(name)) == -1)) {
            return "";
        }
        return name.substring(indexOfFirstSpace(name) + 1, indexOfSecondSpace(name));
    }

    public static String generateLastFirstMidInitial(String name) {
        if ((indexOfFirstSpace(name)) == -1) {
            return name;
        } else if (indexOfSecondSpace(name) == -1) {
            return findLastName(name) + ", " + findFirstName(name);
        }
        return findLastName(name) + ", " + findFirstName(name) + " " 
            + findMiddleName(name).charAt(0) + ".";
    }
}
