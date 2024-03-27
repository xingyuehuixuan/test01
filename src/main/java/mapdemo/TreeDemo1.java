package mapdemo;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeDemo1 {

    public static void main(String[] args) {

        TreeMap<Integer,String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        treeMap.put(1,"aaa");
        treeMap.put(4,"ddd");
        treeMap.put(2,"bbb");
        treeMap.put(3,"ccc");

        System.out.println(treeMap);

    }
}
