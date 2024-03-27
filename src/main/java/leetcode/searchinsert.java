package leetcode;

public class searchinsert {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j)>>>1;
            if (target <= nums[m]){
                j = m - 1;
            }else {
                i = m + 1;
            }
        }
        return i;
    }

}
