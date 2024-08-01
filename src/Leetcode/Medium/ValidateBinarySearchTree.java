package Leetcode.Medium;

import Leetcode.Data.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) ||
            (max != null && root.val >= max)) {
                return false;
        }
        if ((root.left != null && root.left.val >= root.val) || 
            (root.right != null && root.right.val <= root.val)) {
            return false;
        }
        return isValidBST(root.right, root.val, max) && isValidBST(root.left, min, root.val);
    }
}
