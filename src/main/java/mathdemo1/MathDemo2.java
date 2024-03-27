package mathdemo1;

public class MathDemo2 {
    public static void main(String[] args) {
        //判断一个数是否为质数
        System.out.println(isPrime(763));
    }

    public static boolean isPrime(int number){
        for(int i =2;i<Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

}
