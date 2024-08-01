package Leetcode.Easy.BalancedBinaryTree;

import Leetcode.Data.TreeNode;

// time complexity: O(N). Because checkHeight() has to check whether the subtree is balacned or not, the nodes in the tree visited at once.
// space complexity: O(H). Because checkHeight() is called recursively from the root to the terminal to compute the height of the tree 
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public int checkHeight(TreeNode node) {
        if (node == null) return -1;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (Math.abs(leftHeight - rightHeight) > 1) return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
