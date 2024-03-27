package LanQiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BluePaintRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[] split = new int[2];
            for (int j = 0; j < 2; j++) {
                split[j] = sc.nextInt();
            }
            int[] newResult = new int[split[0]];
            for (int j = 0; j < split[0]; j++) {
                newResult[j] = sc.nextInt();
            }
            int minRes = Integer.MAX_VALUE;
            for (int j = 1; j <= 60; j++) {
                int res = 0;
                int k = 0;
                while (k < newResult.length){
                    if (newResult[k] != j){
                        k = k + split[1];
                        res++;
                    }else {
                        k++;
                    }
                }
                if (res < minRes){
                    minRes = res;
                }
            }
            System.out.println(minRes);
        }
    }
}
