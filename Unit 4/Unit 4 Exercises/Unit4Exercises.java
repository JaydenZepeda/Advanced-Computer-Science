import java.util.ArrayList;

public class Unit4Exercises {

    // Method 1: matchingEndSequences
    public static boolean matchingEndSequences(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[nums.length - n + i]) {
                return false;
            }
        }
        return true;
    }

    // Method 2: hasThreeConsecutive
    public static boolean hasThreeConsecutive(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
                oddCount = 0;
            } else if (nums[i] % 2 == 1) {
                oddCount++;
                evenCount = 0;
            }
            if (oddCount == 3 || evenCount == 3) {
                return true;
            }
        }
        return false;
    }

    // Method 3: generateNumberSequence
    public static int[] generateNumberSequence(int start, int end) {
        int[] arr = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            arr[i] = i + start;
        }
        return arr;
    }

    // Method 4: fizzBuzz
    public static String[] fizzBuzz(int start, int end) {
        String[] arr = new String[end - start];
        for (int i = 0; i < end - start; i++) {
            arr[i] = "" + (i + start);
            if ((i + start) % 5 == 0 && (i + start) % 3 == 0) {
                arr[i] = "FizzBuzz";
            } else if ((i + start) % 5 == 0) {
                arr[i] = "Buzz";
            } else if ((i + start) % 3 == 0) {
                arr[i] = "Fizz";
            }
        }
        return arr;
    }

    // Method 5: moveEvenBeforeOdd
    public static int[] moveEvenBeforeOdd(int[] nums) {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        int[] oddArr = new int[oddCount];
        int[] evenArr = new int[evenCount];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenArr[even] = nums[i];
                even++;
            } else {
                oddArr[odd] = nums[i];
                odd++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < evenArr.length) {
                nums[i] = evenArr[i];
            } else {
                nums[i] = oddArr[i - evenArr.length];
            }
        }
        return nums;
    }

    // ArrayList Methods

    // Method 1: noNegatives
    public static ArrayList<Integer> noNegatives(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();

    }

    // Method 2: excludeTeenNumbers
    public static ArrayList<Integer> excludeTeenNumbers(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();
    }

    // Method 3: appendY
    public static ArrayList<String> appendY(ArrayList<String> strs) {
        // to-do: implement the method
        return new ArrayList<>();
    }

    // Method 4: squarePlus10
    public static ArrayList<Integer> squarePlus10(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();
    }

}
