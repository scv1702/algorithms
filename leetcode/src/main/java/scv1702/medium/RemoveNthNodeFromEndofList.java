package scv1702.medium;

import scv1702.data.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next; fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}