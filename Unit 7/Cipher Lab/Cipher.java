public class Cipher {

    public static String encode(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        String encoded = "";
        for (char c : message.toCharArray()) {
            encoded += encodeChar(c);
        }
        return encoded;
    }

    private static char encodeChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ((c - 'A' + 3) % 26 + 'A');
        } else if (c >= 'a' && c <= 'z') {
            return (char) ((c - 'a' + 3) % 26 + 'a');
        } else {
            return c;
        }
    }

    public static String decode(String encodedMessage) {
        if (encodedMessage == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        String decoded = "";
        for (char c : encodedMessage.toCharArray()) {
            decoded += decodeChar(c);
        }
        return decoded;
    }

    private static char decodeChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ((c - 'A' - 3 + 26) % 26 + 'A');
        } else if (c >= 'a' && c <= 'z') {
            return (char) ((c - 'a' - 3 + 26) % 26 + 'a');
        } else {
            return c;
        }
    }

    public static String compress(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (message.length() == 0) {
            return "";
        }
        String compressed = "";
        int count = 1;
        for (int i = 0; i < message.length(); i++) {
            if (i + 1 < message.length() && message.charAt(i) == message.charAt(i + 1)) {
                count++;
            } else {
                compressed += message.charAt(i);

                // RULE: Only append the number if:
                // 1. The count is greater than 1 OR
                // 2. This is NOT the last character in the message
                if (count > 1 || i < message.length() - 1) {
                    compressed += count;
                }
                count = 1;
            }
        }
        return compressed;
    }

    public static String decompress(String compressedMessage) {
        if (compressedMessage == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (compressedMessage.length() == 0) {
            return "";
        }
        String decompressed = "";
        int i = 0;
        while (i < compressedMessage.length()) {
            char c = compressedMessage.charAt(i);
            i++;
            String num = "";
            while (i < compressedMessage.length() && Character.isDigit(compressedMessage.charAt(i))) {
                num += compressedMessage.charAt(i);
                i++;
            }
            int count;
            if (num.isEmpty()) {
                if (i < compressedMessage.length()) {
                    throw new IllegalArgumentException("Invalid Input");
                }
                count = 1;
            } else {
                count = Integer.parseInt(num);
            }
            if (count == 0) {
                throw new IllegalArgumentException("Invalid Input");
            }
            for (int j = 0; j < count; j++) {
                decompressed += c;
            }
        }
        return decompressed;
    }
}
