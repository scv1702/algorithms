package AcmicpcNet.Gold.N14938;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int INF = 15 * 100 * 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = line[0]; // 지역 개수
        int m = line[1]; // 수색 범위
        int r = line[2]; // 길의 개수

        int[] items = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = line[0] - 1;
            int b = line[1] - 1;
            int l = line[2];
            distance[a][b] = distance[b][a] = l;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= m) {
                    s += items[j];
                }
            }
            ans = Math.max(ans, s);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
