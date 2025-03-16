package AcmicpcNet.Gold.N1613;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int INF = 401;

    private static void floyd(int[][] map) {
        int N = map.length - 1;

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(
                        map[i][j],
                        map[i][k] + map[k][j]
                    );
                }
            }
        }
    }

    private static int solve(int[][] map, int u, int v) {
        if (map[u][v] != INF) return -1;
        if (map[v][u] != INF) return 1;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0]; // 사건 개수
        int K = line[1]; // 사건 전후 개수

        int[][] map = new int[1+N][1+N];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < K; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0];
            int v = line[1];
            map[u][v] = 1;
        }

        floyd(map);

        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0];
            int v = line[1];
            int res = solve(map, u, v);
            bw.write(String.format("%d\n", res));
        }

        bw.flush();
        bw.close();
    }
}
