package Leetcode.Medium.PopulatingNextRightPointersInEachNode;

public class PopulatingNextRightPointersInEachNodeIterative {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        Node next = cur.left;
        while (cur != null && next != null) {
            cur.left.next = cur.right;
            if (cur.next != null)
                cur.right.next = cur.next.left;
            cur = cur.next;
            if (cur == null) {
                cur = next;
                next = cur.left;
            }
        }
        return root;
    }
}
