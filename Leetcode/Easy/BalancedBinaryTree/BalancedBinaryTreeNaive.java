package Leetcode.Easy.BalancedBinaryTree;

import Leetcode.Data.TreeNode;

// time complexity: O(N*H)
// space complexity: O(H)
public class BalancedBinaryTreeNaive {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0)) <= 1) 
        && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node, int height) {
        if (node == null) return height-1;
        int leftHeight = getHeight(node.left, height+1);
        int rightHeight = getHeight(node.right, height+1);
        return Math.max(leftHeight, rightHeight);
    }
}
