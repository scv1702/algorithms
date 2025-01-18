package AcmicpcNet.Gold.N1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] dp;
    private static final int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    private static int solve(int[][] arr, int i, int j) {
        int M = arr.length;
        int N = arr[0].length;

        if (dp[i][j] >= 0) return dp[i][j];

        int h = 0;
        for (int[] dir : dirs) {
            int pi = i + dir[0];
            int pj = j + dir[1];
            if (pi < 0 || pi >= M || pj < 0 || pj >= N) continue;
            if (arr[pi][pj] > arr[i][j]) {
                h += solve(arr, pi, pj);
            }
        }

        return dp[i][j] = h;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int M = line[0];
        int N = line[1];

        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        int H = solve(arr, M-1, N-1);

        bw.write(String.valueOf(H));
        bw.flush();
        bw.close();
    }
}
