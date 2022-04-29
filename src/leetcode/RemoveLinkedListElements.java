package leetcode;

/**
 * 203. Remove Linked List Elements (https://leetcode.com/problems/remove-linked-list-elements/)
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = one.next = new ListNode(2);
        ListNode six = two.next = new ListNode(6);
        ListNode three = six.next = new ListNode(3);
        ListNode four = three.next = new ListNode(4);
        ListNode five = four.next = new ListNode(5);
        ListNode six2 = five.next = new ListNode(6);
        new RemoveLinkedListElements().removeElements(one, 6);
    }
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return head;

        ListNode result = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return result;
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
