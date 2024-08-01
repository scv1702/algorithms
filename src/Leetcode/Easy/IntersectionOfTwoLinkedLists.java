package Leetcode.Easy;

import Leetcode.Data.ListNode;

public class IntersectionOfTwoLinkedLists {
    public int getSizeOfLinkedList(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public ListNode get(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeOfA = getSizeOfLinkedList(headA);
        int sizeOfB = getSizeOfLinkedList(headB);
        if (sizeOfA <= sizeOfB) {
            headB = get(headB, sizeOfB - sizeOfA);
        } else {
            headA = get(headA, sizeOfA - sizeOfB);
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}