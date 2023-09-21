package scv1702.medium.LowestCommonAncestorOfABinaryTree;

import scv1702.data.TreeNode;

public class LowestCommonAncestorOfABinaryTreeNaive {
    // 만약 p와 q가 root의 서로 다른 substree에 있다면, root가 lowest common ancestor.
    // p와 q가 root의 한 subtree에 있다면, 해당 subtree에 대해서 재귀적으로 탐색 수행.
    // 해당 방법은 isChildOf()가 동일한 node를 반복적으로 방문한다는 문제가 있음.
    // N은 tree의 node 개수라고 할때 O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        boolean pIsChildOfLeft = isChildOf(root.left, p);
        boolean qIsChildOfLeft = isChildOf(root.left, q);
        if (pIsChildOfLeft != qIsChildOfLeft)
            return root;
        return lowestCommonAncestor(pIsChildOfLeft ? root.left : root.right, p, q);
    }

    public boolean isChildOf(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return isChildOf(root.left, p) || isChildOf(root.right, p);
    }
}
