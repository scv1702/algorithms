package AcmicpcNet.Gold.N17404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] prices = new int[N][3];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                prices[i],
                0,
                3
            );
        }

        int ans = INF;
        int[][] dp = new int[N][3];

        for (int color = 0; color < 3; color++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = INF;
                }
            }

            dp[0][color] = prices[0][color];

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) == INF ?
                        INF : Math.min(dp[i-1][1], dp[i-1][2]) + prices[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) == INF ?
                        INF : Math.min(dp[i-1][0], dp[i-1][2]) + prices[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) == INF?
                        INF : Math.min(dp[i-1][0], dp[i-1][1]) + prices[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j == color) {
                    dp[N-1][j] = INF;
                }
            }

            ans = Math.min(
                ans,
                Arrays.stream(dp[N-1])
                    .min()
                    .orElse(INF)
            );
        }

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
        bw.close();
    }
}
