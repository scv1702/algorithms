package Leetcode.Easy;

import Leetcode.Data.ListNode;

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
