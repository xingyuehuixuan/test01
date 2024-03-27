package leetcode;

public class RemoveElement {
    public ListNode removeElement(ListNode head, int val){
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s.next;
        while (p2 != null){
            if (p2.val == val){
                p1.next = p2.next;
                p2 = p2.next;
            }else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    public ListNode removeElement2(ListNode p, int val){
        if (p == null){
            return null;
        }
        if (p.val == val){
            return removeElement2(p.next, val);
        }else {
            p.next = removeElement2(p.next, val);
            return p;
        }
    }

}
