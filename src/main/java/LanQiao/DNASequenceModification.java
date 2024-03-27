package LanQiao;

import java.util.HashMap;
import java.util.Scanner;

public class DNASequenceModification {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 0);
        hashMap.put('C', 1);
        hashMap.put('G', 2);
        hashMap.put('T', 3);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String b = sc.nextLine();
        char[] bArray = b.toCharArray();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (hashMap.get(a.charAt(i)) + hashMap.get(bArray[i]) != 3){
                for (int j = i + 1; j < n; j++) {
                    if (hashMap.get(a.charAt(i)) + hashMap.get(bArray[j]) == 3 &&
                            hashMap.get(a.charAt(j)) + hashMap.get(bArray[i]) == 3){
                        char t = bArray[i];
                        bArray[i] = bArray[j];
                        bArray[j] = t;
                        break;
                    }
                }
                res++;
            }
        }
        System.out.println(res);
    }
}
