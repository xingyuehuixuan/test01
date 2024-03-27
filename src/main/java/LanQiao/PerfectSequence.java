package LanQiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PerfectSequence {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if(x == 0){
            System.out.println(0);
        }else {
            for (int i = 0; i < x; i++) {
                int r = scan.nextInt();
                if (map.containsKey(r)){
                    map.put(r, map.get(r) + 1);
                }else {
                    map.put(r, 1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getKey() > entry.getValue()){
                    count += entry.getValue();
                } else if (entry.getKey() < entry.getValue()) {
                    count += entry.getValue() - entry.getKey();
                }
            }
            System.out.println(count);
        }
        scan.close();
    }
}
