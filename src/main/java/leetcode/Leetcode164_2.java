package leetcode;

import algorithm.BucketSortPlus;

import java.util.ArrayList;

public class Leetcode164_2 {
    public static int maximumGap(int[] nums){
        if (nums.length < 2){
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        int m = 1;
        while (m <= max){
            for (int num : nums) {
                buckets[num / m % 10].add(num);
            }
            int k = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer i : bucket) {
                    nums[k++] = i;
                }
                bucket.clear();
            }
            m = m * 10;
        }
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }
        return gap;
    }
}
