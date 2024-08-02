package AcmicpcNet.Gold.N1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static class Edge {
        Node v;
        int weight;

        public Edge(Node v, int weight) {
            this.v = v; this.weight = weight;
        }
    }

    static class Node {
        int num;
        List<Edge> edges = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    private static int diameter;

    private static int getHeight(Node node, boolean[] visited) {
        visited[node.num] = true;
        List<Integer> heights = node.edges.stream()
            .filter(edge -> !visited[edge.v.num])
            .map(edge -> getHeight(edge.v, visited) + edge.weight)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        int H = heights.size();
        if (H == 0) {
            return 0;
        }
        if (H >= 2) {
            diameter = Math.max(diameter, heights.get(0) + heights.get(1));
        }
        return heights.get(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[V+1];
        for (int i = 1; i <= V; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= V; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            for (int j = 1; j < line.length - 2; j += 2) {
                int v = Integer.parseInt(line[j]);
                int weight = Integer.parseInt(line[j+1]);
                Edge edge = new Edge(nodes[v], weight);
                nodes[u].edges.add(edge);
            }
        }

        // 트리는 정점의 개수가 N일때, 간선의 개수가 N-1로 연결 그래프다.
        // 트리는 무방향 그래프이다.
        // 트리는 싸이클이 존재하지 않는다.
        // 그러므로, 어떤 정점에서 다른 정점으로 가는 경로가 유일하다.
        boolean[] visited = new boolean[V+1];
        int height = getHeight(nodes[1], visited);
        diameter = Math.max(diameter, height);

        System.out.println(diameter);
    }
}
