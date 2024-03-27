package LanQiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        long[] diff = new long[200001];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt() - 1;
            int p = sc.nextInt();
            diff[s] += p;
            diff[t + 1] -= p;
        }
        for (int i = 1; i < 200001; i++) {
            diff[i] += diff[i - 1];
        }
        for (int i = 0; i < 200001; i++) {
            if (diff[i] > w){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
