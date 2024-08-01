package Leetcode.Medium.PopulatingNextRightPointersInEachNodeII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeIIIterativeNaive {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                level.add(node);
            }
            for (int i = 0; i < level.size() - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
            level.get(level.size() - 1).next = null;
        }
        return root;
    }
}
