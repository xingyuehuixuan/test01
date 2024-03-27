package leetcode;

import java.util.HashSet;

public class Leetcode136 {

    public int singleNumber2(int[] nums){
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
    public int singleNumber1(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                set.remove(num);
            }
        }
        Integer[] integers = (Integer[]) set.toArray();
        return integers[0];
    }
}
