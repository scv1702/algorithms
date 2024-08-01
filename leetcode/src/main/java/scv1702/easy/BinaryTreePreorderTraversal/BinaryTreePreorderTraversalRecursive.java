package scv1702.easy.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import scv1702.data.TreeNode;

public class BinaryTreePreorderTraversalRecursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    
    public void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }
}
