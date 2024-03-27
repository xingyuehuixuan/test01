package leetcode;

import algorithm.InsertionSort;

import java.util.ArrayList;

public class Leetcode164_3 {
    public static int maximumGap(int[] nums){
        if (nums.length < 2){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > max) {
                max = nums[i1];
            }
            if (nums[i1] < min) {
                min = nums[i1];
            }
        }
        int range = Math.max((max - min) / nums.length, 1);
        ArrayList[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i1 = 0; i1 < buckets.length; i1++) {
            buckets[i1] = new ArrayList<>();
        }
        for (int i1 : nums) {
            buckets[(i1 - min) / range].add(i1);
        }
        int k = 0;
        for (ArrayList bucket : buckets) {
            Object[] array = bucket.toArray();
            int[] array1 = new int[array.length];
            for (int i1 = 0; i1 < array1.length; i1++) {
                array1[i1] = (int) array[i1];
            }
            InsertionSort.sort(array1);
            for (int i1 : array1) {
                nums[k++] = i1;
            }
        }
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }
        return gap;
    }
}
