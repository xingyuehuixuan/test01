package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class FourBottlesMysteriousGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = arr[0] + arr[2];
        System.out.println(ans);
    }
}
