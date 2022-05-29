package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 82. Remove Duplicates from Sorted List II (https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> map = new HashMap<>();
        ListNode dummy = new ListNode();
        ListNode dummyTail = dummy;
        ListNode current = head;
        while (head != null) {
            if (head.val == current.val) {
                map.compute(current.val, (k, v) -> (v == null) ? 1 : v + 1);
            } else {
                if (map.get(current.val) == 1) {
                    dummyTail.next = new ListNode(current.val);
                    dummyTail = dummyTail.next;
                }
                current = head;
                map.put(current.val, 1);
            }
            head = head.next;
        }
        if (map.get(current.val) == 1) {
            dummyTail.next = new ListNode(current.val);
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
