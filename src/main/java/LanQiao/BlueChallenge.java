package LanQiao;

import java.util.Scanner;

public class BlueChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
//            Scanner scan = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            int res = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                if (arr[j] == 0){
                    res++;
                    arr[j] += 1;
                }
                sum += arr[j];
            }
            if (sum == 0){
                res++;
            }
            System.out.println(res);
        }

    }
}
