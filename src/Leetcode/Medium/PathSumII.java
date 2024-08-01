package Leetcode.Medium;

import java.util.*;
import Leetcode.Data.TreeNode;

public class PathSumII {
    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        dfs(root, targetSum, new ArrayDeque<>());
        return paths;
    }

    public void dfs(TreeNode root, int targetSum, Deque<Integer> path) {
        if (root == null) return ;
        if (root.left == null && root.right == null) {
            path.offerLast(root.val);
            if (targetSum == root.val) {
                List<Integer> res = new ArrayList<>(path);
                paths.add(res);
            }
            path.pollLast();
            return ;
        }
        path.offerLast(root.val);
        dfs(root.left, targetSum - root.val, path);
        dfs(root.right, targetSum - root.val, path);
        path.pollLast();
    }
}
