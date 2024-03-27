package mapdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class MapDemo2 {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("赵困","sb");
        map.put("李海翔","sb");
        map.put("王海旭","sb");

        Set<String> keySet = map.keySet();


        for (String k : keySet) {
            String s = map.get(k);
            System.out.println(k + s);
        }

        Iterator<String> it = keySet.iterator();
        while (it.hasNext()){
            String next = it.next();
            String s = map.get(next);
            System.out.println(next + s);
        }

        keySet.forEach(s->{
                String s1 = map.get(s);
                System.out.println(s + s1);
            }
        );



    }


}
