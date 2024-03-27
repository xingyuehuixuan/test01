package algorithm;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int binarySearchBasic(int a[],int target){
        int i = 0, j = a.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (a[m] < target){
                i = m +1;
            } else if (target < a[m]) {
                j = m - 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchAlternative(int a[],int target){
        int i = 0, j = a.length;
        while (i < j){
            int m = (i + j) >>> 1;
            if (a[m] < target){
                i = m +1;
            } else if (target < a[m]) {
                j = m;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchLeftMost(int a[],int target){
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (a[m] < target){
                i = m +1;
            } else if (target < a[m]) {
                j = m - 1;
            }else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    public static int binarySearchLeftMost2(int a[],int target){
        int i = 0, j = a.length - 1;

        while (i <= j){
            int m = (i + j) >>> 1;
            if (a[m] < target){
                i = m +1;
            } else{
                j = m - 1;
            }
        }
        return i;
    }

}
