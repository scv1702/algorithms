package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

import Leetcode.Data.TreeNode;

public class UniqueBinarySearchTreesII {
    List<List<List<TreeNode>>> lookup;

    public List<TreeNode> generateTrees(int n) {
        lookup = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lookup.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                lookup.get(i).add(new ArrayList<>());
            }
        }
        lookup.get(1).get(1).add(new TreeNode(1));
        return helper(1, n);
    }

    public List<TreeNode> helper(int i, int j) {
        if (i >= j) {
            List<TreeNode> res = new ArrayList<>();
            res.add(i > j ? null : new TreeNode(i));
            return res;
        }
        if (j < lookup.get(i).size() && lookup.get(i).get(j).size() >= 1)
            return lookup.get(i).get(j);
        for (int k = i - 1; k < j; k++) {
            for (TreeNode left : helper(i, k)) {
                for (TreeNode right : helper(k + 2, j)) {
                    TreeNode root = new TreeNode(k + 1);
                    root.left = left;
                    root.right = right;
                    lookup.get(i).get(j).add(root);
                }
            }
        }
        return lookup.get(i).get(j);
    }
}
