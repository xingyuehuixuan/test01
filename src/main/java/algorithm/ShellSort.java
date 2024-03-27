package algorithm;

import java.util.Arrays;

public class ShellSort {
    public static void sort(int[] a){
        for (int gap = a.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < a.length; low++) {
                int i = low - gap;
                int t = a[low];
                while (i >= 0 && t < a[i]){
                    a[i + gap] = a[i];
                    i = i - gap;
                }
                if (i != low - gap){
                    a[i + gap] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {9, 2, 4, 6, 1, 7, 5};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
