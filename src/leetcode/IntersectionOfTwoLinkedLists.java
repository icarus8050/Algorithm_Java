package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists (https://leetcode.com/problems/intersection-of-two-linked-lists/)
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<Integer> hashSet = new HashSet<>();
        while (headA != null) {
            hashSet.add(headA.hashCode());
            headA = headA.next;
        }

        while (headB != null) {
            if (hashSet.contains(headB.hashCode())) {
                return headB;
            } else {
                hashSet.add(headB.hashCode());
                headB = headB.next;
            }
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
