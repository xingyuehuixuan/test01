package algorithm;

import java.util.Arrays;

public class RecursionFibonacci {

    public static int fibonacciMemory(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return fibonacci(n, cache);
    }

    public static int fibonacci(int n,int[] cache) {
        if (cache[n] != -1){
            return cache[n];
        }
        cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
        return cache[n];
    }
}
