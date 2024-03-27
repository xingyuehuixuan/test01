package LanQiao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaxCardValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        Integer[] d = new Integer[n];
        for (int i = 0; i < n; i++) {
            d[i] = arr2[i] - arr1[i];
        }
        Arrays.sort(d, Collections.reverseOrder());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr1[i];
        }
        k = Math.min(n, k);
        for (int i = 0; i < k; i++) {
            if (d[i] > 0){
                ans += d[i];
            }
        }
        System.out.println(ans);
    }
}
