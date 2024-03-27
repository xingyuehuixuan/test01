package LanQiao;

import java.util.HashMap;

public class test3 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int i = 100; i < 1000; i++) {
            int t = i;
            while (t >= 1){
                hashMap.put(t % 10,hashMap.getOrDefault(t % 10, 0) + 1);
                t /= 10;
            }
            for (int j = 100; j < 1000; j++) {
                int k = j;
                while (k >= 1){
                    hashMap.put(k % 10,hashMap.getOrDefault(k % 10, 0) + 1);
                    k /= 10;
                }
                int res = i + j;
                if (res >= 1000){
                    continue;
                }
                while (res >= 1){
                    hashMap.put(res % 10,hashMap.getOrDefault(res % 10, 0) + 1);
                    res /= 10;
                }
                int p = 0;
                for (int l = 1; l < 10; l++) {
                    if (hashMap.getOrDefault(l, 0) == 0){
                        break;
                    }
                    p++;
                }
                if (p == 9){
                    ans++;
                }
                hashMap.clear();
            }
        }
        System.out.println(ans);
    }
}
