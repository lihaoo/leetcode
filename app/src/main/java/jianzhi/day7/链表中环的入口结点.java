package jianzhi.day7;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode f = pHead;
        ListNode s = pHead;

        while (f != null && s != null) {
            if (f.next == null) {
                return null;
            }
            f = f.next.next;
            s = s.next;

            if (f == s) {
                break;
            }
        }

        ListNode in = f;
        int count = 1;
        ListNode start = in.next;
        while (start != in) {
            count++;
            start = start.next;
        }

        f = pHead;
        s = pHead;

        while (count > 0) {
            f = f.next;
            count--;
        }

        while (s != f) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
