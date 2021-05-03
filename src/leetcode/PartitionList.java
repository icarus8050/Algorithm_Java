package leetcode;

/**
 * 86. Partition List (https://leetcode.com/problems/partition-list/)
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode lessCurrent = less;
        ListNode greaterCurrent = greater;

        while (head != null) {
            if (head.val < x) {
                lessCurrent.next = head;
                lessCurrent = head;
            } else {
                greaterCurrent.next = head;
                greaterCurrent = head;
            }
            head = head.next;
        }
        greaterCurrent.next = null;
        lessCurrent.next = greater.next;
        return less.next;
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
