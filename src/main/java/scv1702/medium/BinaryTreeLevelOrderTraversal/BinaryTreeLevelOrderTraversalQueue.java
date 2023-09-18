package scv1702.medium.BinaryTreeLevelOrderTraversal;

import java.util.*;

import scv1702.data.TreeNode;

public class BinaryTreeLevelOrderTraversalQueue {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> nodesAtTheLevel = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode treeNode = queue.poll();
                nodesAtTheLevel.add(treeNode.val);
                if (treeNode.left != null) 
                    queue.offer(treeNode.left);
                if (treeNode.right != null) 
                    queue.offer(treeNode.right);
            }
            res.add(nodesAtTheLevel);
        }
        return res;
    }
}
