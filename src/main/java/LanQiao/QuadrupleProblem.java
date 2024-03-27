package LanQiao;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class QuadrupleProblem {
    public static boolean FoursNumberFind(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        int[] min_r = new int[n];
        Arrays.fill(min_r, Integer.MAX_VALUE);
        for (int i = n - 2; i >= 0; i--) {
            min_r[i] = Math.min(min_r[i + 1], nums[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < k){
                if (nums[i] > min_r[i]){
                    return true;
                }
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                k = Math.max(k, stack.peek());
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (FoursNumberFind(nums)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
