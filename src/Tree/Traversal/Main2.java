package Tree.Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

    static class Node {
        String num;
        Node left;
        Node right;

        public Node(String num) {
            this.num = num;
        }
    }

    static Map<String, Integer> idxs = new HashMap<>();

    public static int find(String num) {
        return idxs.get(num);
    }

    public static Node reconstruct(String[] postorder, int pi, int ii, int ij) {
        if (ii > ij) {
            return null;
        }
        Node root = new Node(postorder[pi]);
        int rootIdx = find(root.num);
        int R = ij - rootIdx;
        root.left = reconstruct(postorder, pi - 1 - R, ii, rootIdx - 1);
        root.right = reconstruct(postorder, pi - 1, rootIdx + 1, ij);
        return root;
    }

    public static void preorder(Node node, StringBuilder sb) {
        if (node == null) {
            return ;
        }
        sb.append(node.num).append(" ");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inorder = br.readLine().split(" ");
        for (int i = 0; i < inorder.length; i++) {
            idxs.put(inorder[i], i);
        }
        String[] postorder = br.readLine().split(" ");
        Node root = reconstruct(postorder, N - 1, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        System.out.println(sb);
    }
}
