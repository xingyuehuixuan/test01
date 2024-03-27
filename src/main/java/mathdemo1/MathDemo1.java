package mathdemo1;

import org.example.Main;

public class MathDemo1 {

    public static void main(String[] args) {
        //abs获取绝对值
        System.out.println(Math.abs(88));
        System.out.println(Math.abs(-88));
        //ceil向上取整
        System.out.println(Math.ceil(15.3));
        System.out.println(Math.ceil(-12.5));
        //floor向下取整
        System.out.println(Math.floor(15.3));
        System.out.println(Math.floor(-12.5));
        //round四舍五入
        System.out.println(Math.round(15.3));
        System.out.println(Math.round(-12.5));
        //max获取较大值
        System.out.println(Math.max(1,2));
        //min获取较小值
        System.out.println(Math.min(1,2));
        //pow获取a的b次幂
        System.out.println(Math.pow(2,3));
        //sqrt开平方根
        //cbrt开立方根
        System.out.println(Math.sqrt(4));
        System.out.println(Math.cbrt(64));
        //random获取随机数[0.0,1.0)
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.floor(Math.random()*100)+1);
        }
    }
}
