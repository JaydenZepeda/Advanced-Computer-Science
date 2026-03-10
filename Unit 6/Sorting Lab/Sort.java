public class Sort {
    private int[] nums;

    public Sort(int[] nums) {
        this.nums = nums;
    }

    public void sortArray() {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                continue;
            } else if (nums[i] < nums[i + 1]) {
                swap(i, i + 1);
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

}