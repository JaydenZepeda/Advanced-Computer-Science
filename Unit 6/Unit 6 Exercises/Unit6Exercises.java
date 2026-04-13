public class Unit6Exercises {

    /**
     * Problem 1 - Factorial: Write a recursive and non-recursive method that
     * returns the factorial
     * of a given number n.
     */
    public static int factorial(int n) {
        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        return num;
    }

    public static int factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    /**
     * Problem 2 - Fibonacci Sequence: Write a recursive and non-recursive method
     * that returns the
     * nth number in the Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static int fibonacciRecursive(int n) {
        int num = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        num = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        return num;
    }

    /**
     * Problem 3 - Sum of Digits: Write a recursive and non-recursive method that
     * returns the sum of
     * the digits of a given integer.
     */
    public static int sumDigits(int n) {
        if (n < 10) {
            return n;
        }
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int sumDigitsRecursive(int n) {
        int num = 0;
        if (n < 10) {
            num += n;
            return num;
        }
        num += n % 10;
        num += sumDigitsRecursive(n / 10);
        return num;
    }

    /**
     * Problem 4 - Count X: Write a recursive and non-recursive method that returns
     * the count of
     * occurrences of 'x' in a given string.
     */
    public static int countX(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                count++;
            }
        }
        return count;
    }

    public static int countXRecursive(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int count = 0;
        if (str.charAt(0) == 'x') {
            count++;
        }
        count += countXRecursive(str.substring(1));
        return count;
    }

    /**
     * Problem 5 - Reverse String: Write a recursive and non-recursive method that
     * returns the
     * reverse of a given string.
     */
    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public static String reverseStringRecursive(String str) {
        String reverse = "";
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            reverse += str.substring(0);
            return reverse;
        }
        reverse += reverseStringRecursive(str.substring(str.length() - 1));
        reverse += reverseStringRecursive(str.substring(0, str.length() - 1));
        return reverse;
    }

    /**
     * Problem 6 - Power of a Number: Write a recursive and non-recursive method
     * that calculates and
     * returns the value of base raised to the power of exponent.
     */
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int powerRecursive(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * powerRecursive(base, exponent - 1);
    }

    /**
     * Problem 7 - Palindrome Checker: Write a recursive and non-recursive method
     * that checks
     * whether a given string is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(str.substring(1, str.length() - 1));
    }

    /**
     * Problem 8 - Greatest Common Divisor (GCD): Write a recursive and
     * non-recursive method that
     * finds and returns the greatest common divisor of two numbers.
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    /**
     * Problem 9 - Bunny Ears 2: We have bunnies standing in a line, numbered 1, 2,
     * ... The odd
     * bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll
     * say have 3 ears,
     * because they each have a raised foot. Recursively return the number of "ears"
     * in the bunny
     * line 1, 2, ... n (without loops or multiplication).
     */

    public static int bunnyEars(int bunnies) {
        int total = 0;
        for (int i = 1; i <= bunnies; i++) {
            if (i % 2 == 0) {
                total += 3;
            } else {
                total += 2;
            }
        }
        return total;

    }

    public static int bunnyEarsRecursive(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        if (bunnies % 2 == 0) {
            return 3 + bunnyEarsRecursive(bunnies - 1);
        } else {
            return 2 + bunnyEarsRecursive(bunnies - 1);
        }
    }

    /**
     * Problem 10 - Binary Search: Write a recursive and non-recursive method that
     * implements the
     * binary search algorithm to find and return the index of a given element in a
     * sorted array.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // Element not found
    }

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
    }

    // DO NOT EDIT! Work on the helper version above this method. This method is to
    // be used for testing purposes only.
    public static int binarySearchRecursive(int[] arr, int key) {
        return binarySearchRecursiveHelper(arr, key, 0, arr.length - 1); // Element not found
    }

}
