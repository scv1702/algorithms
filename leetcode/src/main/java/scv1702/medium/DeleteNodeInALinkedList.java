package scv1702.medium;

import scv1702.data.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    } 
}
