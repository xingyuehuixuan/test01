package algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] a){
        for (int low = 1; low < a.length; low++) {
            int i = low - 1;
            int t = a[low];
            while (i >= 0 && t < a[i]){
                a[i + 1] = a[i];
                i--;
            }
            if (i != low - 1){
                a[i + 1] = t;
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
