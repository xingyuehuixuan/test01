package algorithm;

import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] a){
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max){
                max = a[i];
            }
        }
        int[] count = new int[max + 1];
        for (int v : a) {
            count[v]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                a[k++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 4, 6, 1, 7, 5};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
