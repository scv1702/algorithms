package AcmicpcNet.Gold.N11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int INF = 10000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n][n];

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (u == v) {
                    distance[u][v] = 0;
                } else {
                    distance[u][v] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            int w = line[2];
            distance[u][v] = Math.min(distance[u][v], w);
        }

        for (int k = 0; k < n; k++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    distance[u][v] = Math.min(distance[u][v], distance[u][k] + distance[k][v]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (distance[u][v] == INF) {
                    sb.append(0);
                } else {
                    sb.append(distance[u][v]);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        String ans = sb.toString();
        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
