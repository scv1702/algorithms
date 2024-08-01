package Leetcode.Hard.SerializeAndDeserializeBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import Leetcode.Data.TreeNode;

public class SerializeAndDeserializeBinaryTreeBfs {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        res.append("[");
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == Integer.MIN_VALUE) {
                    sb.append("null").append(",");
                    continue;
                }
                flag = true;
                sb.append(node.val).append(",");
                queue.offer(node.left == null ? new TreeNode(Integer.MIN_VALUE) : node.left);
                queue.offer(node.right == null ? new TreeNode(Integer.MIN_VALUE) : node.right);
            }
            if (flag) res.append(sb);
        }
        res.delete(res.length() - 1, res.length());
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        StringTokenizer st = new StringTokenizer(data.substring(1, data.length() - 1), ",");
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(st.nextToken()));
        queue.offer(root);
        while (!queue.isEmpty() && st.hasMoreTokens()) {
            TreeNode node = queue.poll();
            String left = st.nextToken();
            if (!left.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            String right = st.nextToken();
            if (!right.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
