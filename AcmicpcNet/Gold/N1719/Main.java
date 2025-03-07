package AcmicpcNet.Gold.N1719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0]; // 집하장 개수
        int M = line[1]; // 경로 개수

        int[][] G = new int[1+N][1+N];
        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0];
            int v = line[1];
            int w = line[2];
            G[u][v] = w;
            G[v][u] = w;
        }

        int[][] parents = new int[1+N][1+N];

        for (int start = 1; start <= N; start++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
            boolean[] visited = new boolean[1+N];
            int[] dist = new int[1+N];
            int[] parent = new int[1+N];
            for (int i = 0; i < 1+N; i++) {
                Arrays.fill(dist, INF);
            }

            dist[start] = 0;
            pq.offer(new int[] { start, dist[start] });

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0];
                if (visited[node]) continue;
                visited[node] = true;
                for (int next = 1; next <= N; next++) {
                    if (G[node][next] <= 0) continue;
                    if (dist[next] > dist[node] + G[node][next]) {
                        dist[next] = dist[node] + G[node][next];
                        parent[next] = node;
                        pq.offer(new int[] { next, dist[next] });
                    }
                }
            }

            for (int end = 1; end <= N; end++) {
                if (start == end) continue;
                int p = end;
                while (parent[p] != start) {
                    p = parent[p];
                }
                parents[start][end] = p;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (parents[i][j] > 0) {
                    sb.append(parents[i][j]);
                } else {
                    sb.append('-');
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        String answer = sb.toString();

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
