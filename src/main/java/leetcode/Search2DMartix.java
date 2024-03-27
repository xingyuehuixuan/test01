package leetcode;

public class Search2DMartix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 10));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] changeArray = changeArray(matrix);
        if (changeArray == null){
            return false;
        }
        boolean result = binarySearch(changeArray, target);
        return result;
    }
    public static int[] changeArray(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return null;
        }
        int[] newArray = new int[matrix.length * matrix[0].length];
        //System.out.println(matrix.length * matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            //System.out.println(1);
            System.arraycopy(matrix[i], 0, newArray, i * matrix[i].length, matrix[i].length);
        }
        return newArray;
    }

    public static boolean binarySearch(int[] arr, int target){
        int i = 0, j = arr.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target < arr[m]){
                j = m - 1;
            }else if (target > arr[m]){
                i = m + 1;
            }else {
                return true;
            }
        }
        return false;
    }

}
