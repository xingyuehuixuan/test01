package leetcode;

import java.util.*;

public class Leetcode49 {

    static class ArrayKey {
        int[] key = new int[26];

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(key, arrayKey.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }

        public ArrayKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                key[c - 97]++;
            }
        }
    }

    public List<List<String>> groupAnagrams2(String[] strs){
        HashMap<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey arrayKey = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(arrayKey, arrayKey1 -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        Collection<List<String>> values = map.values();
        return new ArrayList<>(values);
    }
}
