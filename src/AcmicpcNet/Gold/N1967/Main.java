package AcmicpcNet.Gold.N1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static int diameter = 0;

    static class Node {
        int num;
        int weight;
        List<Node> children = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    public static int helper(Node[] nodes, int node) {
        List<Integer> weights = new ArrayList<>();
        for (Node child : nodes[node].children) {
            weights.add(helper(nodes, child.num) + child.weight);
        }
        if (weights.isEmpty()) {
            return 0;
        }
        weights.sort(Comparator.reverseOrder());
        if (weights.size() >= 2) {
            diameter = Math.max(diameter, weights.get(0) + weights.get(1));
        }
        return weights.get(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < N-1; i++) {
            String[] edge = br.readLine().split(" ");
            int parent = Integer.parseInt(edge[0]);
            int child = Integer.parseInt(edge[1]);
            int weight = Integer.parseInt(edge[2]);

            nodes[child].weight = weight;
            nodes[parent].children.add(nodes[child]);
        }
        int W = helper(nodes, 1);
        diameter = Math.max(diameter, W);
        System.out.println(diameter);
    }
}
