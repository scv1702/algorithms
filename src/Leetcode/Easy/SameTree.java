package Leetcode.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

import Leetcode.Data.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        Deque<TreeNode> pq = new ArrayDeque<>();
        Deque<TreeNode> qq = new ArrayDeque<>();
        pq.offerLast(p);
        qq.offerLast(q);
        while (!pq.isEmpty() && !qq.isEmpty()) {
            TreeNode pn = pq.pollLast();
            TreeNode qn = qq.pollLast();
            if (pn.val != qn.val)
                return false;
            if (pn.left == null || qn.left == null) {
                if (pn.left != qn.left)
                    return false;
            }
            if (pn.right == null || qn.right == null) {
                if (pn.right != qn.right)
                    return false;
            }
            if (pn.left != null)
                pq.offerLast(pn.left);
            if (pn.right != null)
                pq.offerLast(pn.right);
            if (qn.left != null)
                qq.offerLast(qn.left);
            if (qn.right != null)
                qq.offerLast(qn.right);
        }
        return pq.isEmpty() && qq.isEmpty();
    }
}
