public class RecursionExercisesTester {

        public static void main(String[] args) {
                // Test Problem 1: Factorial
                testFactorial();

                // Test Problem 2: Fibonacci Sequence
                testFibonacci();

                // Test Problem 3: Sum of Digits
                testSumDigits();

                // Test Problem 4: Count X
                testCountX();

                // Test Problem 5: Reverse String
                testReverseString();

                // Test Problem 6: Power of a Number
                testPower();

                // Test Problem 7: Palindrome Checker
                testIsPalindrome();

                // Test Problem 8: howManyPaths
                testHowManyPaths();

                // Test Problem 9: Binary Search
                testBinarySearch();

                // Test Problem 10: existsPath
                testExistsPath();
        }

        private static void testFactorial() {
                System.out.println("Testing Factorial...");
                System.out.println("Factorial of 5: " + RecursionExercises.factorial(5)); // Expected: 120
                System.out.println("Factorial of 0: " + RecursionExercises.factorial(0)); // Expected: 1
                System.out.println("Factorial of 3: " + RecursionExercises.factorial(3)); // Expected: 6
        }

        private static void testFibonacci() {
                System.out.println("Testing Fibonacci...");
                System.out.println("Fibonacci of 5: " + RecursionExercises.fibonacci(5)); // Expected: 5
                System.out.println("Fibonacci of 0: " + RecursionExercises.fibonacci(0)); // Expected: 0
                System.out.println("Fibonacci of 10: " + RecursionExercises.fibonacci(10)); // Expected: 55
        }

        private static void testSumDigits() {
                System.out.println("Testing Sum of Digits...");
                System.out.println("Sum of Digits of 123: " + RecursionExercises.sumDigits(123)); // Expected: 6
                System.out.println("Sum of Digits of 0: " + RecursionExercises.sumDigits(0)); // Expected: 0
                System.out.println("Sum of Digits of 456: " + RecursionExercises.sumDigits(456)); // Expected: 15
        }

        private static void testCountX() {
                System.out.println("Testing Count X...");
                System.out.println("Count X in 'axbxcxd': " + RecursionExercises.countX("axbxcxd")); // Expected: 3
                System.out.println("Count X in '': " + RecursionExercises.countX("")); // Expected: 0
                System.out.println("Count X in 'xxxxx': " + RecursionExercises.countX("xxxxx")); // Expected: 5
        }

        private static void testReverseString() {
                System.out.println("Testing Reverse String...");
                System.out.println("Reverse String of 'hello': " +
                                RecursionExercises.reverseString("hello")); // Expected: "olleh"
                System.out.println("Reverse String of '': " +
                                RecursionExercises.reverseString("")); // Expected: ""
                System.out.println("Reverse String of 'abc': " +
                                RecursionExercises.reverseString("abc")); // Expected: "cba"
        }

        private static void testPower() {
                System.out.println("Testing Power...");
                System.out.println("Power of 2^3: " + RecursionExercises.power(2, 3)); // Expected: 8
                System.out.println("Power of 0^5: " + RecursionExercises.power(0, 5)); // Expected: 0
                System.out.println("Power of 5^0: " + RecursionExercises.power(5, 0)); // Expected: 1
        }

        private static void testIsPalindrome() {
                System.out.println("Testing Palindrome Checker...");
                System.out.println("Is 'racecar' a palindrome? " +
                                RecursionExercises.isPalindrome("racecar")); // Expected: true
                System.out.println("Is 'hello' a palindrome? " + RecursionExercises.isPalindrome("hello")); // Expected:
                                                                                                            // false
                System.out.println("Is 'a' a palindrome? " + RecursionExercises.isPalindrome("a")); // Expected: true
        }

        private static void testHowManyPaths() {
                System.out.println("Testing howManyPaths...");
                System.out.println("Paths from (0,0) to (2, 3): " +
                                RecursionExercises.howManyPaths(0, 0, 2, 3)); // Expected: 10
                System.out.println("Paths from (2, 3) to (1, 1): " +
                                RecursionExercises.howManyPaths(2, 3, 1, 1)); // Expected: 0
                System.out.println("Paths from (4, 2) to (8, 9): " +
                                RecursionExercises.howManyPaths(4, 2, 8, 9)); // Expected: 330
        }

        private static void testBinarySearch() {
                System.out.println("Testing Binary Search...");
                int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                System.out.println("Binary Search for 5: " +
                                RecursionExercises.binarySearch(arr, 5)); // Expected: 4
                System.out.println("Binary Search for 10: " +
                                RecursionExercises.binarySearch(arr, 10)); // Expected: -1
                System.out.println("Binary Search for 1: " +
                                RecursionExercises.binarySearch(arr, 1)); // Expected: 0
        }

        private static void testExistsPath() {
                System.out.println("Testing existsPath...");
                String[][] grid = { { "cheddar", "ratpoison", "gouda" },
                                { "brie", "gruyere", "jack" },
                                { "ratpoison", "ratpoison", "fontina" },
                                { "camembert", "colby", "muenster" } };
                System.out.println("Path from (0,0) to (3,2)? " +
                                RecursionExercises.existsPath(grid, 0, 0, 3, 2)); // Expected: true
                System.out.println("Path from (3,2) to (0,0)? " +
                                RecursionExercises.existsPath(grid, 3, 2, 0, 0)); // Expected: false
                System.out.println("Path from (1,0) to (3,1)? " +
                                RecursionExercises.existsPath(grid, 1, 0, 3, 1)); // Expected: false

        }

}
