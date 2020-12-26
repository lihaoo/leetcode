package leetcode;

public class _876链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }

        return a;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
