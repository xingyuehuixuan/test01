package LanQiao;

import java.util.Scanner;

public class ComputeFunctionValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(S(x));
    }

    private static int S(int x) {
        if (x == 0){
            return 1;
        }
        if (x % 2 == 0) {
            return S(x / 2);
        } else if (x % 2 != 0) {
            return S(x - 1) + 1;
        }
        return -1;
    }
}
