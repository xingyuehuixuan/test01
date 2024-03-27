package leetcode;

public class FindMinimumValue {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high){
            int m = (low + high) >>> 1;
            if (nums[m] < nums[high]){
                high = m;
            } else {
                low = m + 1;
            }
        }
        return nums[low];
    }

}
