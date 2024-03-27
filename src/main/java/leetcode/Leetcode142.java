package leetcode;

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode r = head;
        ListNode t = head;
        while (r != null && r.next != null) {
            r = r.next.next;
            t = t.next;
            if (r == t){
                t = head;
                while (true){
                    if (t == r){
                        return t;
                    }
                    t = t.next;
                    r = r.next;

                }
            }
        }
        return null;
    }
}
