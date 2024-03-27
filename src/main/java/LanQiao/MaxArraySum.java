package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class MaxArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sum += a[i];
            }
            Arrays.sort(a);
            long[] pre = new long[n + 1];
            for (int i = 1; i < n + 1; i++) {
                pre[i] = pre[i - 1] + a[i - 1];
            }
            long res = sum - pre[2 * k];
            long suf = 0;
            for (int i = n - 1; i > n - k - 1; i--) {
                suf += a[i];
                res = Math.max(res, sum - suf - pre[2 * (k - n + i)]);
            }
            System.out.println(res);
        }
    }
}
