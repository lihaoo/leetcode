package leetcode;

public class _206反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = null;
        ListNode right = head.next;

        while (true) {
            head.next = left;
            left = head;
            head = right;
            if (head == null) {
                break;
            }
            right = head.next;
        }

        return left;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
