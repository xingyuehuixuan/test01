package mathdemo1;

public class MathDemo3 {
    public static void main(String[] args) {
        //统计一共有多少个水仙花数
        int count=0;
        for (int i = 100; i <= 999; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;

            double sum = Math.pow(ge,3) + Math.pow(shi,3) + Math.pow(bai,3);
            if(sum == i){
                count++;
            }
        }
        System.out.println("一共有"+count+"个水仙花数");
    }
}
