package scv1702.medium.PathSumIII;

import scv1702.data.TreeNode;

public class PathSumIIINaive {
    int path = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        return path;
    }

    public void dfs(TreeNode root, long targetSum) {
        if (root == null) return ;
        helper(root, targetSum);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }

    public void helper(TreeNode root, long targetSum) {
        if (root == null) return ;
        if (targetSum == root.val) path += 1;
        helper(root.left, targetSum - root.val);
        helper(root.right, targetSum - root.val);
    }
}
