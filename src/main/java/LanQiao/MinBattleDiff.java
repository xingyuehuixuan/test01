package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class MinBattleDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, arr[i + 1] - arr[i]);
        }
        System.out.println(ans);
    }
}
