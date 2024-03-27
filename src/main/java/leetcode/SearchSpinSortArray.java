package leetcode;

public class SearchSpinSortArray {
    public int search(int[] nums, int target) {
        int spinSort = findSpinSort(nums);
        if (spinSort == 0){
            int result = binarySearch(nums, target);
            return result;
        }else {
            int[] newArray = new int[nums.length];
            System.arraycopy(nums, spinSort, newArray, 0, nums.length - spinSort);
            System.arraycopy(nums, 0, newArray, nums.length - spinSort, spinSort);
            int result = binarySearch(newArray, target);
            if (result == -1){
            }else if (result >= 0 && result <= nums.length - spinSort - 1){
                result += spinSort;
            }else {
                result -= (nums.length - spinSort);
            }
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
    public int binarySearch(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target < nums[m]){
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

}
