package leetcode;

import Heap.MinHeap;

public class Leetcode215 {
    public int findKthLargest(int[] numbers, int k){
        MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(numbers[i]);
        }
        for (int i = k; i < numbers.length; i++) {
            if (numbers[i] > minHeap.peek()){
                minHeap.replace(numbers[i]);
            }
        }
        return minHeap.peek();
    }

}
