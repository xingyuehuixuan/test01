package LanQiao;

import java.util.Scanner;

public class EndlessStones {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int y = 1;
            int res = 0;
            while (y < n){
                int x = y;
                int sum = 0;
                while (y / 10 > 0){
                    sum += y % 10;
                    y = y / 10;
                }
                sum = sum + y;
                y = sum + x;
                res++;
            }
            if (y > n){
                System.out.println(-1);
            }else {
                System.out.println(res);
            }
        }
    }
}
