package Leetcode.Easy;

import Leetcode.Data.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }
    
    public int helper(TreeNode root, int depth) {
        if (root == null) return depth-1;
        return Math.max(helper(root.left, depth), helper(root.right, depth)) + 1;
    }
}
