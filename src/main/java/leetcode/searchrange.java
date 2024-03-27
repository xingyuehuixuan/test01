package leetcode;

public class searchrange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = left(nums, target);
        int right = right(nums, target);
        if (left >= nums.length){
            return new int[]{-1, -1};
        }
        if (nums[left] != target){
            return new int[]{-1, -1};
        }else {
            return new int[]{left, right};
        }
    }
    public int left(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target <= nums[m]){
                j = m - 1;
            }else {
                i = m + 1;
            }
        }
        return i;
    }

    public int right(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target >= nums[m]){
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
        return i - 1;
    }

}
