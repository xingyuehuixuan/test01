package leetcode;

import java.util.HashMap;

public class Roman {
    public int romanToInt(String s) {

        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = hashMap.get(s.charAt(i));
            if(i < s.length()-1 && value < hashMap.get(s.charAt(i+1))){
                answer = answer - value;
            }else {
                answer = answer + value;
            }
        }
        return answer;

    }

}
