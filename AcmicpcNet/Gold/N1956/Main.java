package AcmicpcNet.Gold.N1956;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int INF = 4_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int V = line[0];
        int E = line[1];

        int[][] dist = new int[1+V][1+V];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int a = line[0];
            int b = line[1];
            int c = line[2];
            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = INF;
        for (int start = 1; start <= V; start++) {
            for (int end = start + 1; end <= V ; end++) {
                if (dist[start][end] < INF &&
                    dist[end][start] < INF) {
                    answer = Math.min(answer, dist[start][end] + dist[end][start]);
                }
            }
        }

        if (answer == INF) {
            answer = -1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
