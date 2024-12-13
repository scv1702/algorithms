package AcmicpcNet.Gold.N1916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    arr[i][j] = Integer.MAX_VALUE;
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
            arr[u][v] = Math.min(arr[u][v], w);
        }

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int source = line[0] - 1;
        int destination = line[1] - 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distance = new int[N];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;
        pq.offer(new int[] { source, 0 });

        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            int node = tuple[0];
            int dist = tuple[1];
            if (distance[node] < dist) continue;
            for (int i = 0; i < N; i++) {
                if (arr[node][i] == Integer.MAX_VALUE) continue;
                if (distance[i] > dist + arr[node][i]) {
                    distance[i] = dist + arr[node][i];
                    pq.offer(new int[] { i, distance[i] });
                }
            }
        }

        bw.write(String.valueOf(distance[destination]));
        bw.flush();
        bw.close();
    }
}
