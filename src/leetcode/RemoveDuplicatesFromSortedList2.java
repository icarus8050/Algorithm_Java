package leetcode;

/**
 * 82. Remove Duplicates from Sorted List II (https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (prev.next == current) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummy.next;
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
