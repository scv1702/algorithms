package Leetcode.Easy.PathSum;

import Leetcode.Data.TreeNode;

// time complexity: O(N)
// space complexity: O(H)
// idea: subtract the value of the node from targetSum
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || 
        hasPathSum(root.right, targetSum - root.val);
    }
}