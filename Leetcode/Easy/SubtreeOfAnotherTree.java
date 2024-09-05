package Leetcode.Easy;

import Leetcode.Data.TreeNode;

// time complexity: O(N*M), N is the number of nodes in the tree and M is the number of nodes in the subtree.
// time complexity: O(H), H is the height of the tree.
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (compare(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean compare(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            return compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
        }
        return false;
    }
}
