package leetcode;

public class Leetcode518 {
    public int coinChange(int[] coins, int amount){
        return rec(0, coins, amount);
    }
    private int rec(int index, int[] coins, int remainder){
        if (remainder < 0){
            return 0;
        } else if (remainder == 0) {
            return 1;
        }else {
            int count = 0;
            for (int i = index; i < coins.length; i++) {
                count += rec(i, coins, remainder - coins[i]);
            }
            return count;
        }
    }
}
