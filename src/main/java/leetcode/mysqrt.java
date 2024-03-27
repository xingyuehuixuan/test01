package leetcode;

public class mysqrt {
    public int mySqrt(int x) {
        int i = 0, j = x, result = -1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (m * m <= x){
                i = m + 1;
                result = m;
            }else {
                j = m - 1;
            }
        }
        return result;
    }

}
