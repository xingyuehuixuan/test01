package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class JewelryMaxAlternateSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n % 2 == 0){
            int[] arr1 = new int[n / 2];
            for (int i = 0, j = 0; i < n; i+=2, j++) {
                arr1[j] = Math.abs(arr[i]);
            }
            int[] arr2 = new int[n / 2];
            for (int i = 1, j = 0; i < n; i+=2, j++) {
                arr2[j] = Math.abs(arr[i]);
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if (arr1[0] < arr2[arr2.length - 1]){
                int t = arr1[0];
                arr1[0] = arr2[arr2.length - 1];
                arr2[arr2.length - 1] = t;
            }
            long ans = 0;
            for (int i = 0; i < arr1.length; i++) {
                ans += arr1[i] - arr2[i];
            }
            System.out.println(ans);
        }else {
            int[] arr1 = new int[n / 2 + 1];
            for (int i = 0, j = 0; i < n; i+=2, j++) {
                arr1[j] = Math.abs(arr[i]);
            }
            int[] arr2 = new int[n / 2];
            for (int i = 1, j = 0; i < n; i+=2, j++) {
                arr2[j] = Math.abs(arr[i]);
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if (arr1[0] < arr2[arr2.length - 1]){
                int t = arr1[0];
                arr1[0] = arr2[arr2.length - 1];
                arr2[arr2.length - 1] = t;
            }
            long ans = 0;
            for (int i = 0; i < arr2.length; i++) {
                ans += arr1[i] - arr2[i];
            }
            ans += arr1[arr1.length - 1];
            System.out.println(ans);
        }
    }
}
