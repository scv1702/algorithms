package Leetcode.Medium;

import Leetcode.Data.TreeNode;

public class InorderSuccessorInBSTII {
    public TreeNode findInorderSuccessor(TreeNode node) {
        if (node.right == null) return up(node);
        return down(node.right);
    }

    TreeNode up(TreeNode node) {
        TreeNode parent = node.parent;
        if (parent == null) return null;
        if (parent.right != node) return parent;
        return up(parent);
    }

    TreeNode down(TreeNode node) {
        if (node.left == null) return node;
        return down(node.left);
    }
}
