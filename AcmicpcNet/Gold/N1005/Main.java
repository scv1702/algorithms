package AcmicpcNet.Gold.N1005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int dfs(int[][] graph, boolean[] visited, int[] D, int[] dis, int node) {
        int N = graph.length;
        visited[node] = true;
        for (int i = 0; i < N; i++) {
            if (graph[i][node] == 1) {
                int prev = visited[i] ? dis[i] : dfs(graph, visited, D, dis, i);
                dis[node] = Math.max(dis[node], prev);
            }
        }
        dis[node] += D[node];
        return dis[node];
    }

    public static int solve(int[][] graph, int[] D, int node) {
        int N = graph.length;
        int[] dist = new int[N];
        return dfs(graph, new boolean[N], D, dist, node);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int N = line[0];
            int K = line[1];

            int[] D = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] graph = new int[N][N];

            // 그래프 구성
            for (int i = 0; i < K; i++) {
                line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                int u = line[0] - 1;
                int v = line[1] - 1;
                graph[u][v] = 1;
            }

            int W = Integer.parseInt(br.readLine());

            int dist = solve(graph, D, W - 1);

            bw.write(String.valueOf(dist) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
