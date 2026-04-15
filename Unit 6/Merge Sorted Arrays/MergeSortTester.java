public class MergeSortTester {
    public static void main(String[] args) {
        int[] a = { 1, 2, 7, 15, 30 };
        int[] b = { 3, 4, 8, 17, 20, 21, 23, 28 };
        int[] c = MergeSort.mergeSortedArray(a, b);
        for (int num : c) {
            System.out.print(num + ", ");
        }
    }
}
