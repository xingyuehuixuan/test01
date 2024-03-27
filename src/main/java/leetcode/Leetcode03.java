package leetcode;

import java.util.HashMap;

public class Leetcode03 {
    public int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                begin = Math.max(begin, map.get(ch) + 1);
                map.put(ch, end);
            }else {
                map.put(ch, end);
            }
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        return maxLength;
    }
}
