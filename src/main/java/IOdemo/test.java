package IOdemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("myAPI\\name.txt"));
        ArrayList<Student2> arrayList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] arr = line.split("-");
            Student2 stu2 = new Student2(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3]));
            arrayList.add(stu2);
        }
        bufferedReader.close();

        double weight = 0;
        for (Student2 student2 : arrayList) {
            weight = weight + student2.getWeight();
        }

        double[] arr = new double[arrayList.size()];
        int index = 0;
        for (Student2 student2 : arrayList) {
            arr[index] = student2.getWeight() / weight;
            index++;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i-1];
        }

        double random = Math.random();
        int result = -Arrays.binarySearch(arr, random) - 1;

        Student2 student2 = arrayList.get(result);
        System.out.println(student2);

        double w = student2.getWeight() / 2;
        student2.setWeight(w);

        BufferedWriter bw = new BufferedWriter(new FileWriter("myAPI\\name.txt"));
        for (Student2 stu : arrayList) {
            bw.write(stu.getName() + "-" + stu.getGender() + "-" + stu.getAge() + "-" + stu.getWeight());
            bw.newLine();
        }
        bw.close();
    }
}
