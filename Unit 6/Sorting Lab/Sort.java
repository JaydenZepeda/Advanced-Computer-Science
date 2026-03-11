public class Sort {
    private int[] nums;

    public Sort(int[] nums) {
        this.nums = nums;
    }

    public void sortArray() {
        for (int index = 0; index < nums.length - 1; index++) {
            for (int i = 0; i < nums.length - index - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public void swap(int position1, int position2) {
        int a = nums[position1];
        nums[position1] = nums[position2];
        nums[position2] = a;
    }

    public void printNums() {
        for (int index = 0; index < nums.length; index++) {
            System.out.println(nums[index]);
        }
    }

}