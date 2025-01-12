package AcmicpcNet.Silver.N4883;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int MAX = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                System.arraycopy(
                    Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                    0,
                    arr[i],
                    0,
                    3
                );
            }

            int[][] dp = new int[N][3];
            dp[0][0] = MAX;
            dp[0][1] = arr[0][1];
            dp[0][2] = dp[0][1] + arr[0][2];

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];

                dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + arr[i][1];
                dp[i][1] = Math.min(dp[i][1], dp[i][0] + arr[i][1]);

                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][2];
                dp[i][2] = Math.min(dp[i][2], dp[i][1] + arr[i][2]);
            }

            bw.write(String.format("%d. %d", T, dp[N-1][1]));

            T += 1;
        }

        bw.flush();
        bw.close();
    }
}
