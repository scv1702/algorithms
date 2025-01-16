package AcmicpcNet.Gold.N17485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int FROM_LEFT = 0;
    private static final int FROM_MID = 1;
    private static final int FROM_RIGHT = 2;

    private static void initializeTo(int[][][] arr, int to) {
        int N = arr.length;
        int M = arr[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[i][j][k] = to;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[][] prices = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                prices[i],
                0,
                M
            );
        }

        // dp[i][j]는 지구의 어느 곳에서 출발을 해서 (i, j)까지 도달하는데 걸리는 연료 양
        // dp[i][j][k]는 dp[i-1]에서 k 방향으로 (i, j)로 이동하는데 필요한 연료 양
        // dp[N][0] ~ dp[N][M-1] 중에서 최소값
        int[][][] dp = new int[N][M][3];

        initializeTo(dp, Integer.MAX_VALUE);

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = prices[0][j];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j >= 1) {
                    dp[i][j][FROM_LEFT] = Math.min(dp[i-1][j-1][FROM_MID], dp[i-1][j-1][FROM_RIGHT]) + prices[i][j];
                }
                dp[i][j][FROM_MID] = Math.min(dp[i-1][j][FROM_LEFT], dp[i-1][j][FROM_RIGHT]) + prices[i][j];
                if (j + 1 < M) {
                    dp[i][j][FROM_RIGHT] = Math.min(dp[i-1][j+1][FROM_LEFT], dp[i-1][j+1][FROM_MID]) + prices[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                answer = Math.min(answer, dp[N-1][j][k]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
