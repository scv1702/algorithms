package scv1702.medium;

import scv1702.data.ListNode;

public class PartitionList {
    public ListNode partition(ListNode node, int x) {
        if (node == null) return node;
        ListNode lsHead = null;
        ListNode lsTail = null;
        ListNode gtHead = null;
        ListNode gtTail = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (node.val < x) {
                if (lsHead == null) {
                    lsHead = node;
                    lsTail = node;
                } else {
                    lsTail.next = node;
                    lsTail = node;
                }
            } else {
                if (gtHead == null) {
                    gtHead = node;
                    gtTail = node;
                } else {
                    gtTail.next = node;
                    gtTail = node;
                }
            }
            node = next;
        }
        if (lsHead == null) {
            return gtHead;
        }
        lsTail.next = gtHead;
        return lsHead;
    }
}