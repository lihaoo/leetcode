package jianzhi.day8;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode start = pHead1;
        int length1 = 0;
        while (start != null) {
            start = start.next;
            length1++;
        }

        start = pHead2;
        int length2 = 0;
        while (start != null) {
            start = start.next;
            length2++;
        }

        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                pHead1 = pHead1.next;
            }
        }

        if (length1 < length2) {
            for (int i = 0; i < length2 - length1; i++) {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
