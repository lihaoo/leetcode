package jianzhi.day8;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode start = new ListNode(Integer.MAX_VALUE);
        start.next = pHead;
        while (start != null) {
            ListNode next = start.next;
            if (next != null && start.val == next.val) {
                ListNode nextNext = next.next;
                if (nextNext == null) {
                    start.next = null;
                    start = null;
                    break;
                } else {
                    start.val = nextNext.val;
                    start.next = nextNext.next;
                }
            } else {
                start = start.next;
            }
        }


        return pHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
