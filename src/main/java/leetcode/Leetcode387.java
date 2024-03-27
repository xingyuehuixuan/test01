package leetcode;

public class Leetcode387 {
    public int firstUniqueChar(String s){
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            array[ch - 97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (array[ch - 97] == 1){
                return i;
            }
        }
        return -1;
    }
}
