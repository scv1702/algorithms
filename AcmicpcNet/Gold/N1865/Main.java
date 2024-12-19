package AcmicpcNet.Gold.N1865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int INF = 1_000_000_000;

    private static boolean detectNegativeCycle(int N, List<int[]> edges) {
        int E = edges.size();
        int[] distance = new int[N]; // 한 번에 모든 정점에서 출발
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < E; j++) {
                int[] edge = edges.get(j);
                int u = edge[0];
                int v = edge[1];
                int t = edge[2];
                if (distance[u] == INF) continue;
                if (distance[v] > distance[u] + t) {
                    distance[v] = distance[u] + t;
                    if (i == N - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int N = line[0];
            int M = line[1];
            int W = line[2];

            List<int[]> edges = new ArrayList<>();

            for (int m = 0; m < M; m++) {
                line = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int S = line[0] - 1;
                int E = line[1] - 1;
                int T = line[2];
                edges.add(new int[] { S, E, T });
                edges.add(new int[] { E, S, T });
            }

            for (int w = 0; w < W; w++) {
                line = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int S = line[0] - 1;
                int E = line[1] - 1;
                int T = line[2];
                edges.add(new int[] { S, E, -T });
            }

            if (detectNegativeCycle(N, edges)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
