package leetcode;

import java.util.Arrays;

public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(getKey(s), getKey(t));
    }

    private int[] getKey1(String str) {
        int[] array = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            array[ch - 97]++;
        }
        return array;
    }

    private int[] getKey(String str) {
        int[] array = new int[26];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            array[ch - 97]++;
        }
        return array;
    }
}
