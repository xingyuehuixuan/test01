package runtimedemo;

public class RunTimeDemo1 {
    public static void main(String[] args) {
        //获取Runtime对象、
        Runtime r1 = Runtime.getRuntime();
        //exit
        //r1.exit(0);
        //获得CPU的线程数
        int i = r1.availableProcessors();
        System.out.println(i);
        //总内存大小
        long l = r1.maxMemory() / 1024 / 1024;
        System.out.println(l);
        //已经获取的内存
        System.out.println(r1.totalMemory()/1024/1024);
        //剩余内存大小
        System.out.println(r1.freeMemory()/1024/1024);

    }
}
