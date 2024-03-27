package leetcode;

public class Listcode23a {
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap minHeap = new MinHeap(lists.length);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            t.next = min;
            t = min;
            if (min.next != null){
                minHeap.offer(min.next);
            }
        }
        return s.next;
    }

}
