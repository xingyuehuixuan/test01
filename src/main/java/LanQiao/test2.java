package LanQiao;

public class test2 {
    public static void main(String[] args) {

        for (int i = 1; ; i += 2) {
            int res = 0;
            int t = i;
            while (res < 111){
                res += t;
                t += 2;
            }
            if (res == 111){
                System.out.println(i);
                return;
            }
        }
    }
}
