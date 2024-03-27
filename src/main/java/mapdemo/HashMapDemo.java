package mapdemo;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {

        String[] arr = {"A","B","C","D"};
        ArrayList<String> arrayList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int nextInt = r.nextInt(arr.length);
            arrayList.add(arr[nextInt]);
        }

        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String name : arrayList) {
            if(hashMap.containsKey(name)){
                Integer value = hashMap.get(name);
                value++;
                hashMap.put(name,value);
            }else {
                hashMap.put(name,1);
            }

        }
        System.out.println(hashMap);

        int max = 0;
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int value = entry.getValue();
            if(value > max){
                max = value;
            }
        }



        for (Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() == max){
                System.out.println(entry.getKey() + " " + max);
            }
        }

    }
}
