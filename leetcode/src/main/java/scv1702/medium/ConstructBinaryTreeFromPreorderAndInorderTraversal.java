package scv1702.medium;

import java.util.HashMap;
import java.util.Map;

import scv1702.data.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> indexLookup = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexLookup.put(inorder[i], i);
        }  
        return helper(inorder, 0, inorder.length-1, preorder, 0);
    }   
    
    public TreeNode helper(int[] inorder, int a, int b, int[] preorder, int c) {
        if (a > b || c >= preorder.length) return null;
        // the root is the last element of postorder
        int rootVal = preorder[c];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = indexLookup.get(rootVal);
        root.left = helper(inorder, a, rootIdx - 1, preorder, c + 1);
        root.right = helper(inorder, rootIdx + 1, b, preorder, c + rootIdx + 1 - a);
        return root;
    }
}
