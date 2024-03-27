package strategy;

import java.util.Scanner;

public class TripTest {
    static int tripMethod;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请选择出行方式，1-汽车 2-火车 3-自驾");
            String str = sc.nextLine();
            tripMethod = Integer.parseInt(str);
            if (tripMethod == 1 || tripMethod == 2 || tripMethod == 3){
                new TripMethodStrategy(tripMethod);
                break;
            }else {
                System.out.println("没有这种出行方式，请重新选择");
            }
        }

    }

}
