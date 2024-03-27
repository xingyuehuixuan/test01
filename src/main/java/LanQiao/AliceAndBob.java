package LanQiao;

import java.util.Scanner;

public class AliceAndBob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        while (n != 0){
            int x = sc.nextInt();
            ans += x % 2;
            n--;
        }
        if (ans % 2 == 1){
            System.out.println("Alice");
        }else {
            System.out.println("Bob");
        }
    }
}
