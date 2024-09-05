package Leetcode.Easy.PathSum;

import Leetcode.Data.TreeNode;

// time complexity: O(N)
// space complexity: O(H)
public class PathSumNaive {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode node, int prefixSum, int targetSum) {
        if (node.left == null && node.right == null) {
            if (prefixSum + node.val == targetSum) return true;
            return false;
        }
        boolean flag = false;
        if (node.left != null) {
            flag = dfs(node.left, prefixSum + node.val, targetSum);
        }
        if (flag) return true;
        if (node.right != null) {
            flag = dfs(node.right, prefixSum + node.val, targetSum);
        }
        return flag;
    }
}
