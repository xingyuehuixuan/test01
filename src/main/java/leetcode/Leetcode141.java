package leetcode;

public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode r = head;
        ListNode t = head;
        while (r != null && r.next != null) {
            r = r.next.next;
            t = t.next;
            if (r == t){
                return true;
            }
        }
        return false;
    }
}
