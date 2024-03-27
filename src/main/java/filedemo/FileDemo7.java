package filedemo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileDemo7 {
    public static void main(String[] args) {
        File file = new File("C:\\");
        HashMap<String, Integer> hashMap = getCount(file);
        System.out.println(hashMap);
    }

    public static HashMap<String,Integer> getCount(File file){
        HashMap<String,Integer> hashMap = new HashMap<>();
        File[] files = file.listFiles();
        if (files != null){
            for (File file1 : files) {
                if (file1.isFile()){
                    String[] split = file1.getName().split("\\.");
                    if(split.length >= 2){
                        String s = split[split.length - 1];
                        if (hashMap.containsKey(s)){
                            int count = hashMap.get(s);
                            count++;
                            hashMap.put(s,count);
                        }else {
                            hashMap.put(s,1);
                        }
                    }
                }else {
                    HashMap<String, Integer> hashMap1 = getCount(file1);
                    Set<Map.Entry<String, Integer>> entries = hashMap1.entrySet();
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        int value = entry.getValue();
                        if (hashMap.containsKey(key)){
                            int value1 = hashMap.get(key);
                            value1 = value1 + value;
                            hashMap.put(key,value1);
                        }else {
                            hashMap.put(key,value);
                        }
                    }
                }

            }
        }

        return hashMap;
    }


}
