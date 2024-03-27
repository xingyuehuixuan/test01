package leetcode;

import java.util.HashMap;

public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer put = map.put(num, num);
            if (put != null) {
                return true;
            }
        }
        return false;
    }
}
