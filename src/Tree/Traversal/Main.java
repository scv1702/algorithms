package Tree.Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

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

    public static Node reconstruct(String[] preorder, int pi, int ii, int ij) {
        if (ii > ij) {
            return null;
        }
        Node root = new Node(preorder[pi]);
        int rootIdx = find(root.num);
        int L = rootIdx - ii;
        root.left = reconstruct(preorder,pi + 1, ii, rootIdx - 1);
        root.right = reconstruct(preorder,pi + 1 + L, rootIdx + 1, ij);
        return root;
    }

    public static void postorder(Node node, StringBuilder sb) {
        if (node == null) {
            return ;
        }
        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.num).append(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] preorder = br.readLine().split(" ");
            String[] inorder = br.readLine().split(" ");
            for (int j = 0; j < inorder.length; j++) {
                idxs.put(inorder[j], j);
            }
            Node root = reconstruct(preorder, 0, 0, N - 1);
            StringBuilder sb = new StringBuilder();
            postorder(root, sb);
            System.out.println(sb);
        }
    }
}
