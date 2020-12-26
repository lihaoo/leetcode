package jianzhi.day1;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 * <p>
 * 单向连表的写法
 * 递归
 */

public class _02从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        while (listNode != null) {
            integerArrayList.add(0, listNode.val);
            listNode = listNode.next;
        }

        return integerArrayList;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public void print(ListNode listNode) {
        print(listNode.next);
        System.out.print(listNode);
    }

}
