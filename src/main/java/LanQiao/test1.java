package LanQiao;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int res = 0;
        int days = 0;
        for (int i = 1950; i < 2012; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
                days += 366;
            }else {
                days += 365;
            }
            if (days % 7 ==1){
                res++;
            }
        }
        System.out.println(res);
        scan.close();
    }
}
