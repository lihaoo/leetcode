package leetcode;

public class _142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head.next;

        while (slow != quick) {
            slow = slow.next;
            quick = quick.next.next;
        }

        int i = 1;
        slow = slow.next;
        while (slow != quick) {
            i++;
            slow = slow.next;
        }

        quick = head;
        for (int j = 0; j < i; j++) {
            quick = quick.next;
        }

        slow = head;

        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }

        return quick;
    }
}
