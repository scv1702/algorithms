package Leetcode.Medium.PopulatingNextRightPointersInEachNode;

public class PopulatingNextRightPointersInEachNodeNaive {
    public Node connect(Node root) {
        if (root == null)
            return null;
        connectInside(root);
        Node curr = root;
        while (curr != null) {
            curr.next = null;
            curr = curr.right;
        }
        return root;
    }

    public void connectInside(Node root) {
        if (root == null || root.left == null)
            return;
        root.left.next = root.right;
        connectInside(root.left);
        connectInside(root.right);
        connectOutside(root.left, root.right);
    }

    public void connectOutside(Node rootA, Node rootB) {
        if (rootA == null || rootB == null || rootA.right == null || rootB.left == null)
            return;
        rootA.right.next = rootB.left;
        connectOutside(rootA.right, rootB.left);
    }
}
