package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSortPlus {
    public static void sort(int[] a, int range) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        ArrayList[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i : a) {
            buckets[(i - min) / range].add(i);
        }
        int k = 0;
        for (ArrayList bucket : buckets) {
            Object[] array = bucket.toArray();
            int[] array1 = new int[array.length];
            for (int i = 0; i < array1.length; i++) {
                array1[i] = (int) array[i];
            }
            InsertionSort.sort(array1);
            for (int i : array1) {
                a[k++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 10, 34, 23, 44, 47, 99, 87, 66};
        System.out.println(Arrays.toString(a));
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        ArrayList[] buckets = new ArrayList[(max - min) / 3 + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i : a) {
            buckets[(i - min) / 3].add(i);
        }
        int k = 0;
        for (ArrayList bucket : buckets) {
            Object[] array = bucket.toArray();
            int[] array1 = new int[array.length];
            for (int i = 0; i < array1.length; i++) {
                array1[i] = (int) array[i];
            }
            InsertionSort.sort(array1);
            for (int i : array1) {
                a[k++] = i;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
