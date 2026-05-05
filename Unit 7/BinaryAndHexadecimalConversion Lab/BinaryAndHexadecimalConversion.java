public class BinaryAndHexadecimalConversion {

    // Given an int, returns the binary representation of that int as a String
    // Precondition: num >= 0
    public static String convertIntToBinary(int num) {
        if (num == 0) {
            return "";
        }
        int next = num / 2;
        int remainder = num % 2;
        return "" + convertIntToBinary(next) + remainder;
    }

    // Given a String of a binary representation of an int, returns that int
    // Precondition: binary string is not negative
    public static int convertBinaryToInt(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result = (result * 2) + 1;
            } else {
                result = (result * 2);
            }
        }
        return result;
    }

    // Given an int, returns the hexadecimal representation of that int as a String
    // Precondition: num >= 0
    public static String convertIntToHexadecimal(int num) {
        String hexadecimal = "0123456789abcdef";
        if (num < 16) {
            return String.valueOf(hexadecimal.charAt(num));
        }
        return convertIntToHexadecimal(num / 16) + hexadecimal.charAt(num % 16);
    }

    // Given a String of a hexadecimal representation of an int, returns that int
    // Precondition: hexadecimal string is not negative
    public static int convertHexadecimalToInt(String hex) {
        hex = hex.toLowerCase();
        String hexadecimal = "0123456789abcdef";
        int result = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int value = hexadecimal.indexOf(c);
            result = (result * 16) + value;
        }
        return result;
    }

    // Given a String of a hexadecimal representation of an int,
    // returns the String of the binary representation
    // Precondition: hexadecimal string is not negative
    public static String convertHexadecimalToBinary(String hex) {
        hex = hex.toLowerCase();
        String[] binary = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
                "1011", "1100", "1101", "1110", "1111" };
        String hexadecimal = "0123456789abcdef";
        String result = "";
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int value = hexadecimal.indexOf(c);
            result = result + binary[value];
        }
        return result;
    }

    // Given a String of a binary representation of an int,
    // returns the String of the hexadecimal representation
    // Precondition: hexadecimal string is not negative
    public static String convertBinaryToHexadecimal(String binary) {
        String hexadecimal = "0123456789abcdef";
        String result = "";
        while (binary.length() % 4 != 0) {
            binary = "0" + binary;
        }
        for (int i = 0; i < binary.length(); i += 4) {
            String chunk = binary.substring(i, i + 4);
            int value = 0;
            if (chunk.charAt(0) == '1') {
                value += 8;
            }
            if (chunk.charAt(1) == '1') {
                value += 4;
            }
            if (chunk.charAt(2) == '1') {
                value += 2;
            }
            if (chunk.charAt(3) == '1') {
                value += 1;
            }
            result = result + hexadecimal.charAt(value);
        }
        return result;
    }

    // Converts the String representation of the number to an int.
    // If the String starts with 0b, then convert the rest of the String as if it
    // were binary.
    // If the String starts with 0x, then convert the rest of the String as if it
    // were hexadecimal.
    // If the String starts with neither, then convert the rest of the String as if
    // it were decimal.
    public static int convertStringToInt(String numString) {
        if (numString.startsWith("0b")) {
            return convertBinaryToInt(numString.substring(2));
        } else if (numString.startsWith("0x")) {
            return convertHexadecimalToInt(numString.substring(2));
        } else {
            return Integer.parseInt(numString);
        }
    }
}
