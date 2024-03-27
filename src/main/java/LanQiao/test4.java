package LanQiao;

import java.math.BigInteger;

public class test4 {
    public static void main(String[] args) {
        BigInteger x = BigInteger.valueOf(10L);
        BigInteger y = BigInteger.valueOf(89L);
        for (int i = 1; i < 61; i++) {
            y = y.subtract(x);
            if (i % 3 == 0){
                x = x.multiply(BigInteger.valueOf(2L));
            }
            if (i % 2 == 0){
                y = y.multiply(BigInteger.valueOf(2L));
            }
        }
        System.out.println(y);
    }
}
