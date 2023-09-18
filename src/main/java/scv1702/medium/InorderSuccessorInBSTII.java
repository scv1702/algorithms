package scv1702.medium;

import scv1702.data.TreeNode;

public class InorderSuccessorInBSTII {
    public TreeNode findInorderSuccessor(TreeNode node) {
        if (node.right == null) return up(node);
        return down(node.right);
    }

    TreeNode up(TreeNode node) {
        TreeNode parent = node.parent;
        if (parent == null) return node;
        if (parent.right != node) return parent;
        return up(parent);
    }

    TreeNode down(TreeNode node) {
        if (node.left == null) return node;
        return down(node.left);
    }
}
