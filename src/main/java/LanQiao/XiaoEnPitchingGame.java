package LanQiao;

import java.util.Scanner;

public class XiaoEnPitchingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long[] diff = new long[n + 1];
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int c = sc.nextInt();
            diff[l] += c;
            diff[r + 1] -= c;
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        for (int i = 0; i < n; i++) {
            long x = arr[i] + diff[i];
            System.out.print(x + " ");
        }
    }
}
