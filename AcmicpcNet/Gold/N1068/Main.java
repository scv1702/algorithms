package AcmicpcNet.Gold.N1068;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    static class Node {
        int num;
        Node parent;
        Set<Node> children = new HashSet<>();

        public Node(int num) {
            this.num = num;
        }

        public void addChild(Node node) {
            children.add(node);
            node.parent = this;
        }

        public void delete() {
            if (this.parent != null) {
                this.parent.children.remove(this);
            }
            children.clear();
        }

        @Override
        public boolean equals(Object o) {
            if (! (o instanceof Node)) return false;
            Node node = (Node) o;
            return this.num == node.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }

    private static int ans = 0;
    private static void dfs(Node node) {
        if (node == null) return ;
        if (!node.children.isEmpty()) {
            for (Node child : node.children) {
                dfs(child);
            }
        } else {
            ans += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        int[] parents = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int deletedNode = Integer.parseInt(br.readLine());

        Node root = null;
        for (int i = 0; i < N; i++) {
            int parent = parents[i];
            if (parent >= 0) {
                nodes[parent].addChild(nodes[i]);
            } else {
                root = nodes[i];
            }
        }

        if (nodes[deletedNode] == root) {
            root = null;
        }
        nodes[deletedNode].delete();

        dfs(root);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
