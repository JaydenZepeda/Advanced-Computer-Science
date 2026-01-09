public class Unit3ExercisesTester {
    public static void main(String[] args) {
        testCalculateIntrest();
    }

    public static void testCalculateStringLengthAverage() {
        // Test Case - Main Case
        String[] letters = { "abc", "cde", "efg", "hij" };
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));

        // Test Case - Edge Case: Null element array
        letters = new String[] { "abc", "cde", "efg", null, "hij" };
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));

        // Test Case - Edge CAse: Null array
        try {
            letters = null;
            // expected output: 0
            System.out.println("Expected exception: " + Unit3Exercises.calculateAverageStringLength(letters));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testReverseString() {
        // Test Case - Main Case
        String testString = "abc";
        System.out.println("Expected cba: " + Unit3Exercises.reverseString(testString));

        // Test Case - Edge Case: String with spaces at the end and in the middle
        testString = " ab c ";
        System.out.println("Expected ' c ba ': " + Unit3Exercises.reverseString(testString));

        // Test Case - Edge Case: String with special characters
        testString = "a1b!c&";
        System.out.println("Expected '&c!b1a': " + Unit3Exercises.reverseString(testString));

        // Test Case - Edge Case: Null string
        try {
            testString = null;
            System.out.println("Expected exception: " + Unit3Exercises.reverseString(testString));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the string was null, as intended");
        }
    }

    public static void testFindMaxValue() {
        // Main case
        int[] nums = { 1, 9, 10, 12, 15, 2, 20, 3, 4, 21 };
        System.out.println("Expected 21: " + Unit3Exercises.findMaxValue(nums)); // 21 expected

        // Edge - neg, 0, and positive nums
        nums = new int[] { 0, -1, 9, 10, 12, 0, 2, -20, 3, -4, -21 };
        System.out.println("Expected 12: " + Unit3Exercises.findMaxValue(nums));// 12 expected

        // Edge - only neg nums
        nums = new int[] { -1, -9, -10, -12, -15, -2, -20, -3, -4, -21 };
        System.out.println("Expected -1: " + Unit3Exercises.findMaxValue(nums));// -1 expected

        // Edge - null
        try {
            nums = null;
            // expected output: null
            System.out.println("Expected exception: " + Unit3Exercises.findMaxValue(nums));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testIsPalindrome() {

        // Main Case
        String testString = "deed";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));

        // Edge case - non- palindrome
        testString = "hello";
        System.out.println("Expected false: " + Unit3Exercises.isPalindrome(testString));

        // Edge case - null
        try {
            testString = null;
            // expected output: null
            System.out.println("Expected exception: " + Unit3Exercises.isPalindrome(testString));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }

        // Edge case - empty ""
        testString = "i";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));
    }

    public static void testSumEvenNumbers() {
        // Main case
        int[] nums = { 1, 9, 10, 12, 15, 2, 20, 3, 4, 21 };
        System.out.println("Expected 48: " + Unit3Exercises.sumEvenNumbers(nums)); // 48 expected

        // Edge - neg even and odd nums
        nums = new int[] { -1, -9, -10, -12, -15, -2, -20, -3, -4, -21 };
        System.out.println("Expected -48: " + Unit3Exercises.sumEvenNumbers(nums)); // -48 expected

        // Edge - pos and neg even and odd nums
        nums = new int[] { -1, 9, -10, 12, -15, 2, -20, 3, -4, 21 };
        System.out.println("Expected -20: " + Unit3Exercises.sumEvenNumbers(nums)); // -20 expected

        // Edge - null array
        nums = null;
        try {
            nums = null;
            // expected output: 0
            System.out.println("Expected exception: " + Unit3Exercises.sumEvenNumbers(nums));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testCalculateSumOfSquares() {
        // Main Case
        int[] nums = { 1, 2, 3 };
        System.out.println("Expected 14: " + Unit3Exercises.calculateSumOfSquares(nums));

        // Edge - null
        nums = null;
        System.out.println("Expected 14: " + Unit3Exercises.calculateSumOfSquares(nums)); // expected error

        // Edge - neg nums
        nums = new int[] { -1, -2, -3 };
        System.out.println("Expected 14: " + Unit3Exercises.calculateSumOfSquares(nums));
    }

    public static void testGetNthFibonacci() {
        // Main Case
        int n = 0;
        System.out.println("Expected 0: " + Unit3Exercises.getNthFibonacci(n));
        n = 1;
        System.out.println("Expected 0: " + Unit3Exercises.getNthFibonacci(n));
        n = 2;
        System.out.println("Expected 1: " + Unit3Exercises.getNthFibonacci(n));
        n = 3;
        System.out.println("Expected 2: " + Unit3Exercises.getNthFibonacci(n));
        n = 4;
        System.out.println("Expected 3: " + Unit3Exercises.getNthFibonacci(n));
        n = 5;
        System.out.println("Expected 5: " + Unit3Exercises.getNthFibonacci(n));

        // Edge - neg num
        n = -3;
        System.out.println("Expected error: " + Unit3Exercises.getNthFibonacci(n));
    }

    public static void testSortArrayDescending() {
        // Main Case
        int[] nums = { 1, 3, 5, 2, 4, };
        System.out.println("Expected 5, 4, 3, 2, 1: " + Unit3Exercises.sortArrayDescending(nums)); // success

        // Main Case - neg nums
        nums = new int[] { -1, -3, -5, -2, -4, };
        System.out.println("Expected -1, -2, -3, -4, -5: " + Unit3Exercises.sortArrayDescending(nums)); // success

        // Edge - null
        nums = null;
        System.out.println("Expected error" + Unit3Exercises.sortArrayDescending(nums)); // success
    }

    public static void testFindLongestWord() {
        // Main Case
        String sentence = "I like kentucky fried chicken";
        System.out.println("Expected kentucky: " + Unit3Exercises.findLongestWord(sentence));
        sentence = "Do not do drugs";
        System.out.println("Expected drugs: " + Unit3Exercises.findLongestWord(sentence));

        // Main Case
        sentence = "Big Fat Lie";
        System.out.println("Expected Big: " + Unit3Exercises.findLongestWord(sentence));

        // Edge - empty/null
        sentence = "";
        System.out.println("Expected error: " + Unit3Exercises.findLongestWord(sentence));
        sentence = null;
        System.out.println("Expected error: " + Unit3Exercises.findLongestWord(sentence));
    }

    public static void testCalculateIntrest() {
        double principal = 200;
        double rate = 10.5;
        int years = 5;
        System.out.println("Expected 329.489: " + Unit3Exercises.calculateInterest(principal, rate, years));

        principal = 100;
        rate = 12;
        years = 10;
        System.out.println("Expected 310.58: " + Unit3Exercises.calculateInterest(principal, rate, years));

        // Edge - neg principal
        principal = -100;
        rate = 10;
        years = 5;
        System.out.println("Expected error: " + Unit3Exercises.calculateInterest(principal, rate, years));

        // Edge - neg rate
        principal = 100;
        rate = -10;
        years = 5;
        System.out.println("Expected error: " + Unit3Exercises.calculateInterest(principal, rate, years));

        // Edge - neg year
        principal = 100;
        rate = 10;
        years = -5;
        System.out.println("Expected error: " + Unit3Exercises.calculateInterest(principal, rate, years));
    }
}
