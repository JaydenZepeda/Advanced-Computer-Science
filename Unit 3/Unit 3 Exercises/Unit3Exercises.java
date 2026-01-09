public class Unit3Exercises {
    // Intended: return the average length of the strings in the array.
    public static double calculateAverageStringLength(String[] strs) {
        if (strs == null) {// if null array
            return 0;
        }
        int sum = 0;
        // doesnt check for null
        int x = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null) {
                sum += strs[i].length();
                x++;
            }
        } // if was only calculating every other
        return sum / x;
    }

    // Intended: produce a new string with the characters of the input reversed.
    public static String reverseString(String str) {
        if (str == null) {
            return null;
        }
        String reversed = "";
        for (int i = str.length() - 1; i > -1; i--) { // skipped last -- 0 = -1
            reversed = reversed + str.charAt(i);
        } // added extra on 3 % = 0
          // adds extra space
        return reversed;
    }

    public static int findMaxValue(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        int max = numbers[0]; // makes sure 0 is not incorrectly the max
        for (int i = 0; i < numbers.length; i++) {// = makes it go to a higher index than there is and 1 makes it not
                                                  // include first value
            if (numbers[i] > max) {// has to be the same num that is changed to
                max = numbers[i];
            }
        }
        return max;
    }

    // Intended: check whether the input string reads the same forwards and
    // backwards.
    public static boolean isPalindrome(String str) {
        if (str == null) {
            System.out.println("null is not a palindrome");
            return false;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char a = str.charAt(left);
            char b = str.charAt(right); // no minus 1
            if (a != b) {
                return false;// irrelavant to intention
            }
            left++;
            right--;
        }
        return true;// irrelavant
    }

    // Intended: sum only the even numbers in the array.
    public static int sumEvenNumbers(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];// i + 1 means the next num not the even one
            } // no else needed
        }
        if (sum == 0) {
            sum = numbers.length;
        }
        return sum;
    }

    public static int calculateSumOfSquares(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Invalid entry");
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) { // having i = 1 will skip first index
            sum += Math.pow(numbers[i], 2);
        }
        return sum;
    }

    public static int getNthFibonacci(int n) {
        if (n < 0) { // 1 should be valid
            throw new IllegalArgumentException("Invalid number");
        }
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static int[] sortArrayDescending(int[] arr) { // nothing is returned
        if (arr == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {// is doing ascending
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            throw new IllegalArgumentException("Empty or null input");
        }
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }
        return longestWord;
    }

    public static double calculateInterest(double principal, double rate, int years) {
        if (principal < 0 || rate < 0 || years < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        for (int i = 0; i < years; i++) {
            principal += principal * (rate / 100);
        }
        return principal;
    }
}
