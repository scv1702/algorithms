package AcmicpcNet.Gold.N22865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int[] dijkstra(List<List<int[]>> G, int start) {
        int N = G.size() - 1;
        boolean[] visited = new boolean[1+N];
        int[] dist = new int[1+N];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));

        dist[start] = 0;
        pq.offer(new int[] { start, dist[start] });

        while (!pq.isEmpty()) {
            int curr = pq.poll()[0];
            if (visited[curr]) continue;
            visited[curr] = true;
            for (int[] next : G.get(curr)) {
                if (dist[next[0]] > dist[curr] + next[1]) {
                    dist[next[0]] = dist[curr] + next[1];
                    pq.offer(new int[] { next[0], dist[next[0]] });
                }
            }
        }

        return dist;
    }

    private static int min(int... A) {
        return Arrays.stream(A).min().orElse(0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 자취할 땅 후보
        int[] F = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray(); // 친구 위치
        int M = Integer.parseInt(br.readLine()); // 도로 개수

        List<List<int[]>> G = new ArrayList<>();
        G.add(List.of());
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0];
            int v = line[1];
            int w = line[2];
            G.get(u).add(new int[] { v, w });
            G.get(v).add(new int[] { u, w });
        }

        int[] fromA = dijkstra(G, F[0]);
        int[] fromB = dijkstra(G, F[1]);
        int[] fromC = dijkstra(G, F[2]);

        int answer = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int min = min(fromA[i], fromB[i], fromC[i]);
            if (min > max) {
                max = min;
                answer = i;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
