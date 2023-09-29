package scv1702.easy;

import scv1702.data.ListNode;

public class ReverseLinkedList {
    ListNode head;

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        helper(head);
        return this.head;
    }

    public ListNode helper(ListNode head) {
        if (head.next == null) {
            this.head = head;
            return this.head;
        }
        ListNode tail = helper(head.next);
        tail.next = head;
        head.next = null;
        return head;
    }
}
