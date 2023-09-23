package scv1702.easy;

import scv1702.data.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.val != b.val) return false;
        return helper(a.left, b.right) && helper(a.right, b.left);
    }
}
