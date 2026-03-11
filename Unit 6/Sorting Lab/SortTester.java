public class SortTester {

    public static void main(String[] args) {

        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200);
        }
        Sort list = new Sort(arr);
        list.sortArray();
        list.printNums();
    }
}
