package scv1702.easy;

import scv1702.data.ListNode;

public class PalindromeLinkedList {
        public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode backward = prev;
        if (fast != null && fast.next == null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode foward = next;
        while (backward != null) {
            if (backward.val != foward.val) {
                return false;
            }
            backward = backward.next;
            foward = foward.next;
        }
        return true;
    }
}
