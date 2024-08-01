package Leetcode.Hard.SerializeAndDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import Leetcode.Data.TreeNode;

public class SerializeAndDeserializeBinaryTreeDfs {
    int valsIdx;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder();
        res.append("[");
        helper(root, res);
        res.delete(res.length() - 1, res.length());
        res.append("]");
        return res.toString();
    }
    
    public void helper(TreeNode node, StringBuilder res) {
        if (node == null) {
            res.append("null").append(",");
            return ;
        }
        res.append(node.val).append(",");
        helper(node.left, res);
        helper(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        StringTokenizer st = new StringTokenizer(data.substring(1, data.length()-1), ",");
        List<String> vals = new ArrayList<>();
        while (st.hasMoreTokens()) {
            vals.add(st.nextToken());
        }
        return helper(vals);
    }
    
    public TreeNode helper(List<String> vals) {
        if (vals.get(valsIdx).equals("null")) {
            valsIdx += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals.get(valsIdx)));
        valsIdx += 1;
        node.left = helper(vals);
        node.right = helper(vals);
        return node;
    }
}
