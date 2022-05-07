package leetcode;

/**
 * 206. Reverse Linked List (https://leetcode.com/problems/reverse-linked-list/)
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        while (temp.next != null) {
            ListNode tempNext = temp.next;
            temp.next = temp.next.next;
            tempNext.next = head;
            head = tempNext;
        }
        return head;
    }

    public static class ListNode {
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
