package Leetcode.Medium.PathSumIII;

import java.util.*;
import Leetcode.Data.TreeNode;

public class PathSumIII {
        int path = 0;
    Map<Long, Integer> lookup = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        lookup.put(0L, 1);
        dfs(root, 0L, targetSum);
        return path;
    }

    public void dfs(TreeNode root, long prefixSum, int targetSum) {
        if (root == null) return ;
        prefixSum += root.val;
        path += lookup.getOrDefault(prefixSum - targetSum, 0);
        lookup.put(prefixSum, lookup.getOrDefault(prefixSum, 0) + 1);
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);
        lookup.put(prefixSum, lookup.get(prefixSum) - 1);
    }
}
