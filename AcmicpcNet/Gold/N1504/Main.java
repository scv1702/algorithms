package AcmicpcNet.Gold.N1504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] dijkstra(int[][] graph, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int N = graph.length;
        int[] distance = new int[N];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.offer(new int[] { start , 0 });

        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            int node = tuple[0];
            int dist = tuple[1];
            if (distance[node] < dist) continue;
            for (int i = 0; i < N; i++) {
                if (graph[node][i] == Integer.MAX_VALUE) continue;
                if (distance[i] > dist + graph[node][i]) {
                    distance[i] = dist + graph[node][i];
                    pq.offer(new int[] { i, distance[i] });
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 ~ v1 ~ v2 ~ N
        // dist(1, v1) + dist(v1, v2) + dist(v2, N)
        // dist(1, v2) + dist(v2, v1) + dist(v1, N)

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int E = line[1];

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            int w = line[2];
            graph[u][v] = graph[v][u] = w;
        }

        line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int V1 = line[0] - 1;
        int V2 = line[1] - 1;

        int[] oneTo = dijkstra(graph, 0);

        int oneToV1 = oneTo[V1];
        int oneToV2 = oneTo[V2];

        int V1ToV2 = dijkstra(graph, V1)[V2];

        int[] toN = dijkstra(graph, N-1);

        int V1ToN = toN[V1];
        int V2ToN = toN[V2];

        int ans = Integer.MAX_VALUE;

        if (oneToV1 != Integer.MAX_VALUE &&
            V1ToV2 != Integer.MAX_VALUE &&
            V2ToN != Integer.MAX_VALUE) {
            ans = Math.min(ans, oneToV1 + V1ToV2 + V2ToN);
        }

        if (oneToV2 != Integer.MAX_VALUE &&
            V1ToV2 != Integer.MAX_VALUE &&
            V1ToN != Integer.MAX_VALUE) {
            ans = Math.min(ans, oneToV2 + V1ToV2 + V1ToN);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
