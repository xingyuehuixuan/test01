package leetcode;

public class SearchSpinSortArrayT {
    public boolean search(int[] nums, int target) {
        int spinSort = findSpinSort(nums);
        if (spinSort == 0){
            boolean result = binarySearch(nums, target);
            return result;
        }else {
            int[] newArray = new int[nums.length];
            System.arraycopy(nums, spinSort, newArray, 0, nums.length - spinSort);
            System.arraycopy(nums, 0, newArray, nums.length - spinSort, spinSort);
            boolean result = binarySearch(newArray, target);
            return result;
        }
    }
    public int findSpinSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                return i + 1;
            }
        }
        return 0;
    }
    public boolean binarySearch(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target < nums[m]){
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
