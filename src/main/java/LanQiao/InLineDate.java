package LanQiao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InLineDate {
    public static void main(String[] args) {
        int res = 0;
        LocalDate start = LocalDate.of(2022, 1, 1);
        LocalDate end = LocalDate.of(2022, 12, 31);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        while (start.compareTo(end) <= 0){
            String now = start.format(dateTimeFormatter);
            if (isLegal(now)){
                res++;
                System.out.println(now);
            }
            start = start.plusDays(1);
        }
        System.out.println(res);
    }

    private static boolean isLegal(String now) {
        int l = 0;
        int length = now.length();
        while (l <= length - 3){
            int t1 = (int)Integer.valueOf(now.substring(l, l + 1));
            int t2 = (int)Integer.valueOf(now.substring(l + 1, l + 2));
            int t3 = (int)Integer.valueOf(now.substring(l + 2, l + 3));
            if (t1 == t2 - 1 && t2 == t3 -1){
                return true;
            }
            l++;
        }
        return false;
    }

}
