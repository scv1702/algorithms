package AcmicpcNet.Gold.N1277;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static double INF = 200_001 * 1000;

    private static double distance(int[] A, int[] B) {
        return Math.sqrt(Math.pow(A[0]-B[0], 2) + Math.pow(A[1]-B[1], 2));
    }

    private static double[] dijkstra(double[][] G, int start) {
        int N = G.length - 1;
        double[] dist = new double[1+N];
        boolean[] visited = new boolean[1+N];
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> p[1]));

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new double[] { start, dist[start] });

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            if (visited[node]) continue;
            visited[node] = true;
            for (int next = 1; next <= N; next++) {
                if (G[node][next] < 0) continue;
                if (dist[next] > dist[node] + G[node][next]) {
                    dist[next] = dist[node] + G[node][next];
                    pq.offer(new double[] { next, dist[next] });
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0]; // 발전소 수
        int W = line[1]; // 남아있는 전선 수
        double M = Double.parseDouble(br.readLine()); // 최대 길이

        int[][] F = new int[1+N][2]; // 발전소 위치
        for (int i = 1; i <= N; i++) {
            F[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        double[][] G = new double[1+N][1+N];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(G[i], -1);
        }
        for (int i = 0; i < W; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int A = line[0];
            int B = line[1];
            G[A][B] = G[B][A] = 0;
        }

        for (int A = 1; A <= N; A++) {
            for (int B = A; B <= N; B++) {
                if (G[A][B] >= 0) continue;
                double dist = distance(F[A], F[B]);
                if (dist <= M) {
                    G[A][B] = G[B][A] = dist;
                }
            }
        }

        double[] dist = dijkstra(G, 1);
        int answer = (int) (dist[N] * 1000);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
