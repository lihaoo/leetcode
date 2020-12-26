package leetcode;

public class _160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA, b = headB;
        int aa = 0;
        while (headA != headB) {
            if (headA.next != null) {
                headA = headA.next;
            } else {
                headA = b;
                aa++;
            }

            if (headB.next != null) {
                headB = headB.next;
            } else {
                headB = a;
            }
            if (aa >= 2) {
                break;
            }
        }
        if (aa >= 2) {
            return null;
        }
        return headA;
    }
}
