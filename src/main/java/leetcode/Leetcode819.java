package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else {
                String key = sb.toString();
                if (!set.contains(key)){
                    map.compute(key, (k, v) -> v == null ? 1 : v + 1);
                }
                sb.setLength(0);
            }
        }
        if (sb.length() > 0){
            String key = sb.toString();
            if (!set.contains(key)){
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int max = 0;
        String maxKey = null;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
