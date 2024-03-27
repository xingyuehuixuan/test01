package algorithm;

import java.util.Arrays;

public class QuickSortLomuto {
    public static void sort(int[] a){
        quick(a, 0, a.length - 1);
    }
    private static void quick(int[] a, int left, int right){
        if (left >= right){
            return;
        }
        int p =  partition(a, left, right);
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pv = a[right];
        int i = left;
        int j = left;
        while (j < right){
            if (a[j] < pv){
                if (i != j){
                    swap(a, i, j);
                }
                i++;
            }
            j++;
        }
        swap(a, i, right);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {9, 2, 4, 6, 1, 7, 5};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
