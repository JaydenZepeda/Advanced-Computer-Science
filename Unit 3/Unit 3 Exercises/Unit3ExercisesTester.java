public class Unit3ExercisesTester {
    public static void main(String[] args) {
        testSumEvenNumbers();
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
}
