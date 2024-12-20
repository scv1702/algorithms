package AcmicpcNet.Gold.N11779;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final long INF = 10_000_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[][] graph = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            int w = line[2];
            graph[u][v] = Math.min(graph[u][v], w);
        }

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int source = line[0] - 1;
        int destination = line[1] - 1;

        long[] distance = new long[N];
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        int[] prev = new int[N];
        Arrays.fill(distance, INF);
        Arrays.fill(prev, -1);

        distance[source] = 0;
        pq.offer(new long[] { source, 0 });

        while (!pq.isEmpty()) {
            long[] tuple = pq.poll();
            int node = (int) tuple[0];
            long dest = tuple[1];
            if (distance[node] < dest) continue;
            for (int next = 0; next < N; next++) {
                if (distance[next] > dest + graph[node][next]) {
                    distance[next] = dest + graph[node][next];
                    prev[next] = node;
                    pq.offer(new long[] { next, distance[next] });
                }
            }
        }

        long dist = distance[destination];
        List<Integer> routes = new ArrayList<>();
        int node = destination;
        while (node != -1) {
            routes.add(node);
            node = prev[node];
        }
        Collections.reverse(routes);
        String res = routes.stream()
                .map(a -> a + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(String.valueOf(dist) + '\n');
        bw.write(String.valueOf(routes.size()) + '\n');
        bw.write(res);
        bw.flush();
        bw.close();
    }
}
