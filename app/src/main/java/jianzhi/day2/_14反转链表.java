package jianzhi.day2;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 链表的反转 记住固定的写法
 * 1.使用两个临时变量
 * 2.初始值必须有一个是head的上一个节点 也就是mull
 * </p>
 * <p>
 * 还有使用栈的方法
 * </p>
 */

public class _14反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode a = null;
        ListNode b = head.next;

        while (b != null) {
            head.next = a;
            a = head;
            head = b;
            b = head.next;head.next = a;
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
