package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class AdventurerGuild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[][] arr2 = new int[n][(int) 1e3 + 1];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            arr2[i][0] = k;
            for (int j = 1; j <= k; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.sort(arr2[i], 1, arr2[i][0] + 1);
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, arr2[i][0]);
        }
        long ans = 0;
        for (int i = 0; i < maxLength; i++) {
            int maxAbility = 0;
            for (int j = 0; j < n; j++) {
                if (arr2[j][0] - i >= 1){
                    maxAbility = Math.max(maxAbility, arr2[j][arr2[j][0] - i]);
                }
            }
            int j = 0;
            for (; j < m; j++) {
                if (arr[j] >= maxAbility){
                    ans += arr[j];
                    break;
                }
            }
            if (j == m){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }
}
