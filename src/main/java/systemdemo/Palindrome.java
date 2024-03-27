package systemdemo;

public class Palindrome {
    public static void main(String[] args) {
        boolean result = isPalindrome(1234321);
        System.out.println(result);
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int flag = 0;
        int count = x;
        while (true){
            if(x==0){
                break;
            }
            int ge = x % 10;
            flag = flag * 10 + ge;
            x = x / 10;
        }
        if(flag == count){
            return true;
        }else {
            return false;
        }

    }

}
