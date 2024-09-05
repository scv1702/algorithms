package AcmicpcNet.Silver.N11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Node {
        int num;
        List<Node> nexts = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    public static void dfs(Node node, boolean[] visited, int[] parent, int prev) {
        visited[node.num] = true;
        parent[node.num] = prev;

        for (Node next : node.nexts) {
            if (!visited[next.num]) {
                dfs(next, visited, parent, node.num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= N-1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            Node unode = nodes[u];
            Node vnode = nodes[v];

            unode.nexts.add(vnode);
            vnode.nexts.add(unode);
        }

        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];

        dfs(nodes[1], visited, parent, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append(" ");
        }

        System.out.println(sb);
    }
}
