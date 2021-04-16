package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 61. Rotate List (https://leetcode.com/problems/rotate-list/)
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode tail = head;
        Deque<ListNode> deque = new LinkedList<>();
        while (tail != null) {
            deque.addLast(tail);
            tail = tail.next;
        }
        k %= deque.size();

        for (int i = 0; i < k; i++) {
            deque.addFirst(deque.pollLast());
        }

        head = deque.pollFirst();
        tail = head;
        while (!deque.isEmpty()) {
            tail.next = deque.pollFirst();
            tail = tail.next;
        }
        tail.next = null;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
