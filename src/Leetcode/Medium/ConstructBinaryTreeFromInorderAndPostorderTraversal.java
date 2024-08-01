package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

import Leetcode.Data.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> indexLookup = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexLookup.put(inorder[i], i);
        }  
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }   
    
    public TreeNode helper(int[] inorder, int a, int b, int[] postorder, int c, int d) {
        if (a > b || c > d) return null;
        // the root is the last element of postorder
        int rootVal = postorder[d];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = indexLookup.get(rootVal);
        root.left = helper(inorder, a, rootIdx - 1, postorder, c, c + rootIdx - 1 - a);
        root.right = helper(inorder, rootIdx + 1, b, postorder, c + rootIdx - a, d-1);
        return root;
    }
}
