package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1636 {
    public static int[] frequencySort(int[] nums){
        int[] count = new int[201];
        for (int num : nums) {
            count[num + 100]++;
        }
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] a = {2, 2, 4, 6, 1, 7, 5};
        System.out.println(Arrays.toString(a));
        int[] result = frequencySort(a);
        System.out.println(Arrays.toString(result));
    }
}
