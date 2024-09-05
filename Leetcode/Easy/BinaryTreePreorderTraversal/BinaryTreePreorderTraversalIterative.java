package Leetcode.Easy.BinaryTreePreorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import Leetcode.Data.TreeNode;

public class BinaryTreePreorderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.add(node.val);
            if (node.right != null) {
                stack.offerLast(node.right);
            }
            if (node.left != null) {
                stack.offerLast(node.left);
            }
        }
        return res;
    }
}
