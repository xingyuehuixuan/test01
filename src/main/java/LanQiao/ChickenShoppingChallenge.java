package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class ChickenShoppingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int i = 0;
        for (; i < n; i++) {
            if (arr[i] > 0){
                break;
            }
        }
        int t = n - i;
        long ans = 0;
        if (t % 2 == 0){
            for (int j = i; j < n; j++) {
                ans += arr[j];
            }
        }else {
            if (i - 1 >= 0 && arr[i] > Math.abs(arr[i - 1])){
                for (int j = i - 1; j < n; j++) {
                    ans += arr[j];
                }
            }else {
                for (int j = i + 1; j < n; j++) {
                    ans += arr[j];
                }
            }
        }
        System.out.println(ans);
    }
}
