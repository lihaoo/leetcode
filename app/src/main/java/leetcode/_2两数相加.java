package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        while (l1 != null) {
            a.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            b.add(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode(0);
        ListNode out = head;
        boolean addMore = false;
        while (!a.isEmpty() || !b.isEmpty() || addMore) {
            int temp = 0;
            if (addMore) {
                temp++;
            }

            if (!a.isEmpty()) {
                temp += a.remove(0);
            }

            if (!b.isEmpty()) {
                temp += b.remove(0);
            }

            if (temp >= 10) {
                addMore = true;
                temp -= 10;
            } else {
                addMore = false;
            }
            head.next = new ListNode(temp);
            head = head.next;
        }

        return out.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
