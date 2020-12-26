package jianzhi.day2;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 双指针做法
 * </p>
 */

public class _13链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        return null;
    }

    private ListNode turnListNode(ListNode head) {
        ListNode listNode = new ListNode(0);
        while (head.next != null) {
            listNode = head.next;
            head = head.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
