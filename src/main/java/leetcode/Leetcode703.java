package leetcode;

import Heap.MinHeap;

public class Leetcode703 {
    private MinHeap heap;

    public Leetcode703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }
    public int add(int val){
        if (!heap.isFull()){
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }
}
