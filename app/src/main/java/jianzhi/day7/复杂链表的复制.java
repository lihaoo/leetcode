package jianzhi.day7;

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode next = head.next;
            RandomListNode head1 = copyNode(head);
            head.next = head1;
            head1.next = next;
            head = next;
        }

        head = pHead;

        while (head != null) {
            RandomListNode head1 = head.next;
            if (head.random != null) {
                head1.random = head.random.next;
            }
            head = head.next.next;
        }

        head = pHead;
        RandomListNode result = pHead.next;
        RandomListNode head1 = pHead.next;

        while (head != null) {
            if (head.next != null) {
                head.next = head.next.next;
                head = head.next;
            }
            if (head1.next != null) {
                head1.next = head1.next.next;
                head1 = head1.next;
            }
        }
        return result;
    }

    private RandomListNode copyNode(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode randomListNode = new RandomListNode(pHead.label);
        return randomListNode;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
