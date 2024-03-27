package algorithm;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortHoare {
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
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a, idx, left);
        int pv = a[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && a[j] > pv){
                j--;
            }
            while (i < j && a[i] <= pv){
                i++;
            }
            swap(a, i ,j);
        }
        swap(a, i, left);
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
