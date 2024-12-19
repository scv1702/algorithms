package AcmicpcNet.Gold.N1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final int INF = 1_000_000_000;

    private static int[] dijkstra(int[][] graph, int source) {
        int N = graph.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distance = new int[N];
        Arrays.fill(distance, INF);

        distance[source] = 0;
        pq.offer(new int[] { source, 0 });

        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            int node = tuple[0];
            int dist = tuple[1];
            if (distance[node] < dist) continue;
            for (int i = 0; i < N; i++) {
                if (distance[i] > graph[node][i] + dist) {
                    distance[i] = graph[node][i] + dist;
                    pq.offer(new int[]{i, distance[i]});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];
        int X = line[2] - 1;

        int[][] forward = new int[N][N];
        int[][] backward = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    forward[i][j] = 0;
                    backward[i][j] = 0;
                } else {
                    forward[i][j] = INF;
                    backward[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            int t = line[2];
            forward[u][v] = t;
            backward[v][u] = t;
        }

        int[] fdist = dijkstra(backward, X);
        int[] bdist = dijkstra(forward, X);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, fdist[i] + bdist[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
