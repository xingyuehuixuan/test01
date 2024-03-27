package systemdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {

        ArrayList<Character> arrayList = new ArrayList<>();
        String str = strs[0];

        for (int j = 0; j < str.length(); j++) {

            char c = str.charAt(j);
            for (int i = 1; i < strs.length; i++) {

                if(strs[i].length() < j + 1 || c != strs[i].charAt(j)){
                    return arrayList.stream().map(Object::toString).collect(Collectors.joining(""));
                }
            }
            arrayList.add(c);

        }

        return arrayList.stream().map(Object::toString).collect(Collectors.joining(""));


    }

}
