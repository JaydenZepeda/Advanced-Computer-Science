public class Unit4ExercisesTester {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 45, 99, 13, 5, 6 };
        System.out.println(Unit4Exercises.matchingEndSequences(nums, 1));

        nums = new int[] { 2, 1, 3, 5 };
        System.out.println(Unit4Exercises.hasThreeConsecutive(nums));

        System.out.println(Unit4Exercises.generateNumberSequence(5, 10));

        System.out.println(Unit4Exercises.fizzBuzz(2, 16));

        nums = new int[] { 1, 0, 1, 0, 0, 1, 1 };
        Unit4Exercises.moveEvenBeforeOdd(nums);
    }
}
