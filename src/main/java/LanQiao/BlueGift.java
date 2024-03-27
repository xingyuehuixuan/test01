package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class BlueGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += arr[i];
            if (res <= k){
                ans++;
            }else {
                res -= arr[i];
                int t = arr[i] % 2 == 0 ? arr[i] / 2 : arr[i] / 2 + 1;
                if (res + t <= k){
                    ans++;
                }
                break;
            }
        }
        System.out.println(ans);
    }
}
