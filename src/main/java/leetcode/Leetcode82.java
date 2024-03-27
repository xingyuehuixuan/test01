package leetcode;

public class Leetcode82 {
    public ListNode delete(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return delete(x);
        } else {
            p.next = delete(p.next);
            return p;
        }
    }

    public ListNode delete2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) {
                }
                p1.next = p3;
            }else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(2, null);
        ListNode o4 = new ListNode(2, o5);
        ListNode o3 = new ListNode(1, o4);
        ListNode o2 = new ListNode(1, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        System.out.println(new Leetcode82().delete(o1));
    }
}
