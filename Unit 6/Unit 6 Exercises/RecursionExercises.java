public class RecursionExercises {

    /**
     * Returns n!
     */
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Returns the nth number in the Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        int num = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        num = fibonacci(n - 1) + fibonacci(n - 2);
        return num;
    }

    /**
     * Returns the sum of the digits of a given integer.
     */
    public static int sumDigits(int n) {
        int num = 0;
        if (n < 10) {
            num += n;
            return num;
        }
        num += n % 10;
        num += sumDigits(n / 10);
        return num;
    }

    /**
     * Returns the count of occurrences of 'x' in a given string.
     */
    public static int countX(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int count = 0;
        if (str.charAt(0) == 'x') {
            count++;
        }
        count += countX(str.substring(1));
        return count;
    }

    /**
     * Returns the reverse of a given string.
     */
    public static String reverseString(String str) {
        String reverse = "";
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            reverse += str.substring(0);
            return reverse;
        }
        reverse += reverseString(str.substring(str.length() - 1));
        reverse += reverseString(str.substring(0, str.length() - 1));
        return reverse;
    }

    /**
     * Returns the value of base raised to the power of exponent.
     */
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    /**
     * Returns whether a given string is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    /**
     * Returns how many paths a fancy rat could take from (startRow, startColumn) to
     * (endRow, endColumn)
     * if it could only move right or down
     */
    public static int howManyPaths(int startRow, int startColumn, int endRow, int endColumn) {
        if (startRow == endRow && startColumn == endColumn) {
            return 1;
        }
        if (startRow > endRow || startColumn > endColumn) {
            return 0;
        }
        return howManyPaths(startRow + 1, startColumn, endRow, endColumn)
                + howManyPaths(startRow, startColumn + 1, endRow, endColumn);
    }

    /**
     * DO NOT EDIT! Write the recursive helper method below instead.
     */
    public static int binarySearch(int[] arr, int key) {
        return binarySearchRecursiveHelper(arr, key, 0, arr.length - 1);
    }

    /**
     * Implements the binary search algorithm to find and return the index of a
     * given element in a sorted array if it is between low and high, or -1 if it is
     * not found between low and high.
     */
    public static int binarySearchRecursiveHelper(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (key < arr[mid]) {
            return binarySearchRecursiveHelper(arr, key, low, mid - 1);
        } else {
            return binarySearchRecursiveHelper(arr, key, mid + 1, high);
        }
        // Element not found
    }

    /**
     * Returns whether there exists a path from (startRow, startColumn) to
     * (endRow, endColumn) in the 2D rewards array
     * that never goes through the String "ratpoison"
     */
    public static boolean existsPath(String[][] rewards, int startRow, int startColumn,
            int endRow, int endColumn) {
        if (startRow < 0 || startRow >= rewards.length || startColumn < 0 || startColumn >= rewards[0].length) {
            return false;
        }
        if (rewards[startRow][startColumn].equals("ratpoison")) {
            return false;
        }
        if (startRow == endRow && startColumn == endColumn) {
            return true;
        }
        return existsPath(rewards, startRow + 1, startColumn, endRow, endColumn)
                || existsPath(rewards, startRow, startColumn + 1, endRow, endColumn);
    }

}
