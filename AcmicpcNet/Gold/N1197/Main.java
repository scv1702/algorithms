package AcmicpcNet.Gold.N1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    private static void union(int[] nodes, int[] rank, int u, int v) {
        int ru = find(nodes, u);
        int rv = find(nodes, v);

        if (ru == rv) {
            return ;
        }

        if (rank[ru] < rank[rv]) {
            nodes[ru] = rv;
        } else {
            nodes[rv] = ru;
            if (rank[ru] == rank[rv]) {
                rank[ru] += 1;
            }
        }
    }

    private static int find(int[] nodes, int u) {
        if (nodes[u] == u) {
            return u;
        }
        return nodes[u] = find(nodes, nodes[u]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int V = line[0];
        int E = line[1];

        int[][] edges = new int[E][3];
        int[] nodes = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < E; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            int w = line[2];

            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = w;
        }

        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        int ans = 0;

        for (int i = 0; i < E; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(nodes, u) != find(nodes, v)) {
                ans += w;
                union(nodes, rank, u, v);
            }
        }

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
        bw.close();
    }
}
