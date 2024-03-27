package algorithm;

import java.util.function.Consumer;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(14);
        dynamicArray.addLast(56);
        dynamicArray.add(3, 5);
        dynamicArray.add(5, 9);
        dynamicArray.addLast(76);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(dynamicArray.get(i));
//        }
//        dynamicArray.foreach(element -> System.out.println(element) );
//        for (Integer element : dynamicArray) {
//            System.out.println(element);
//        }
//        dynamicArray.stream().forEach(element -> System.out.println(element));
        dynamicArray.foreach(element -> System.out.println(element));

    }
}
