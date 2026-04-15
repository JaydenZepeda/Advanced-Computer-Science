public class MergeSort {

    public static int[] mergeSortedArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < c.length; i++) {
            if (indexA >= a.length) {
                c[i] = b[indexB];
                indexB++;
            } else if (indexB >= b.length) {
                c[i] = a[indexA];
                indexA++;
            } else if (a[indexA] <= b[indexB]) {
                c[i] = a[indexA];
                indexA++;
            } else {
                c[i] = b[indexB];
                indexB++;
            }
        }
        return c;
    }

}
