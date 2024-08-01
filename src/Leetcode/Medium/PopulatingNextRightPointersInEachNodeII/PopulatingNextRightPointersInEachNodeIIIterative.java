package Leetcode.Medium.PopulatingNextRightPointersInEachNodeII;

public class PopulatingNextRightPointersInEachNodeIIIterative {
    public Node getNextNode(Node cur) {
        while (cur != null) {
            if (cur.left != null)
                return cur.left;
            if (cur.right != null)
                return cur.right;
            cur = cur.next;
        }
        return null;
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        Node nextLevel = cur.left == null ? cur.right : cur.left;
        while (cur != null && nextLevel != null) {
            if (cur.left != null) {
                if (cur.right != null) {
                    cur.left.next = cur.right;
                } else {
                    cur.left.next = getNextNode(cur.next);
                }
            }
            if (cur.right != null) {
                cur.right.next = getNextNode(cur.next);
            }
            cur = cur.next;
            if (cur == null) {
                cur = nextLevel;
                nextLevel = getNextNode(cur);
            }
        }
        return root;
    }
}
