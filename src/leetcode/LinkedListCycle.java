package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle (https://leetcode.com/problems/linked-list-cycle/)
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }

            set.add(head);
            head = head.next;
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        System.out.println(new LinkedListCycle().hasCycle(one));
    }
}
