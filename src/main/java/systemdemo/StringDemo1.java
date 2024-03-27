package systemdemo;

import java.util.ArrayList;

public class StringDemo1 {

    public static void main(String[] args) {
        String str = "dvdf";
        int result = lengthOfLongestSubstring(str);
        System.out.println(result);
    }
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int flag = 0;
        if(s.isEmpty()){
            return 0;
        }else {
            while(true){
                int[] result = getLength(s, i);
                if(result[0] == s.length()){
                    return s.length();
                }else{
                    if(result[0] > flag){
                        flag = result[0];
                    }
                    i = result[1];
                    if(i == s.length()){
                        return flag;
                    }
                }
            }
        }


    }

    private static int[] getLength(String str, int a){
        int flag = 0;
        ArrayList<Character> array = new ArrayList<>();
        array.add(str.charAt(a));
        //System.out.println(a);
        for(int i = a + 1; i < str.length(); i++){
            if(array.contains(str.charAt(i))){
                int index = array.indexOf(str.charAt(i));

                return new int[]{i-a,index+1+a};
            }
            array.add(str.charAt(i));
        }
        if(a == 0){
            flag = str.length();
        }else{
            flag = str.length() - a;
        }

        return new int[]{flag,str.length()};
    }


}
