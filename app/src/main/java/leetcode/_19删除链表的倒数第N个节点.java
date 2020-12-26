package leetcode;

public class _19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0 || head == null) {
            return head;
        }

        ListNode s = head, q = head;
        while (n-- > 0) {
            q = q.next;
            if (q == null) {
                return head;
            }
        }

        ListNode t = s;
        while (q.next != null) {
            t = s;
            s = s.next;
            q = q.next;
        }

        if (t == head) {
            return t.next;
        } else {
            t.next = s.next;
            return head;
        }

    }
}
