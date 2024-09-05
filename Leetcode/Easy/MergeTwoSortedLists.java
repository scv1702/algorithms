package Leetcode.Easy;

import Leetcode.Data.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        helper(tail, list1, list2);
        return head.next;
    }

    public void helper(ListNode tail, ListNode list1, ListNode list2) {
        if (list1 == null) {
            tail.next = list2;
            return;
        }
        if (list2 == null) {
            tail.next = list1;
            return;
        }
        if (list1.val <= list2.val) {
            tail.next = list1;
            list1 = list1.next;

        } else {
            tail.next = list2;
            list2 = list2.next;
        }
        tail = tail.next;
        helper(tail, list1, list2);
    }
}
