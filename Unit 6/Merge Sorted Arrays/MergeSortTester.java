public class MergeSortTester {
    public static void main(String[] args) {
        int[] a = { 1, 2, 7, 15, 30 };
        int[] b = { 3, 6, 8, 1, 5, 21, 30, 28 };
        int[] c = MergeSort.mergeSort(b);
        for (int num : c) {
            System.out.print(num + ", ");
        }
    }
}
