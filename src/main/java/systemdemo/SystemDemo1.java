package systemdemo;

public class SystemDemo1 {
    public static void main(String[] args) {
        //exit
        //System.exit(0);
        //currentTimeMillions
        //long l = System.currentTimeMillis();
        //System.out.println(l);
        //arraycopy
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = new int[9];
        System.arraycopy(arr1,0,arr2,4,3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
}
