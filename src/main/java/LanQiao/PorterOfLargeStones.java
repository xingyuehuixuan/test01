package LanQiao;

import java.util.*;

public class PorterOfLargeStones {
    static class Pair implements Comparable<Pair> {
        int weight;
        int position;

        public Pair(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }

        @Override
        public int compareTo(Pair o) {
            return this.position - o.position;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] q = new Pair[n];
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int position = sc.nextInt();
            q[i] = new Pair(weight, position);
        }
        Arrays.sort(q);
        long[] pre = new long[n + 1];
        long[] next = new long[n + 1];
        long s = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i == 1){
                pre[i] = 0;
            }else {
                pre[i] = pre[i - 1] + s * (q[i - 1].position - q[i - 2].position);
            }
            s += q[i - 1].weight;
        }
        s = 0;
        for (int i = n; i >=1; i--) {
            if (i == n){
                next[i] = 0;
            }else {
                next[i] = next[i + 1] + s * (q[i].position - q[i - 1].position);
            }
            s += q[i - 1].weight;
        }
        long res = Long.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            res = Math.min(res, pre[i] + next[i]);
        }
        System.out.println(res);
    }
}
