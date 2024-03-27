package LanQiao;

import java.util.Scanner;

public class XiaoEnPitchingGamePlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        long[][] diff = new long[n][m + 1];
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            int c = sc.nextInt();
            for (int j = 0; j < x2 - x1 + 1; j++) {
                diff[x1 + j][y1] += c;
                diff[x1 + j][y2 + 1] -= c;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long x = arr[i][j] + diff[i][j];
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
