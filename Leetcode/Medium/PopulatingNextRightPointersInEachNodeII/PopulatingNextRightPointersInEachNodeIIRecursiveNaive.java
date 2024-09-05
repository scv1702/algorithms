package Leetcode.Medium.PopulatingNextRightPointersInEachNodeII;

public class PopulatingNextRightPointersInEachNodeIIRecursiveNaive {
    Node prev;

    public int getHeight(Node root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public Node connect(Node root) {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            helper(root, i);
            prev = null;
        }
        Node curr = root;
        while (curr != null) {
            curr.next = null;
            if (curr.right != null) {
                curr = curr.right;
                continue;
            }
            curr = curr.left;
        }
        return root;
    }

    public void helper(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            if (prev != null)
                prev.next = root;
            prev = root;
            return;
        }
        helper(root.left, level - 1);
        helper(root.right, level - 1);
    }
}
