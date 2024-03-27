package algorithm;

import java.util.Arrays;

public class MergeSortBottomUp {
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2){
        int k = i;
        while (i <= iEnd && j <= jEnd){
            if (a1[i] < a1[j]){
                a2[k] = a1[i];
                i++;
            }else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd){
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd){
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    public static void sort(int[] a){
        int n = a.length;
        int[] a2 = new int[n];
        for (int width = 1; width < n; width *= 2) {
            for (int left = 0; left < n; left = left + width * 2) {
                int right = Math.min(left + width * 2 - 1, n - 1);
                int m = Math.min(left + width - 1, n - 1);
                merge(a, left, m, m + 1, right, a2);
            }
            System.arraycopy(a2, 0, a, 0, n);
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 2, 4, 6, 1, 7, 5};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}