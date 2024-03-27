package leetcode;

public class Merge2SortedArray {
    public void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k) {
        if (i > iEnd){
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd){
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }
        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }

    public void merge2(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2){
        int k = 0;
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

}
