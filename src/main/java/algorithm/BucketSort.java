package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
    public static void sort(int[] a) {
        ArrayList[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i : a) {
            buckets[i / 10].add(i);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
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
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
