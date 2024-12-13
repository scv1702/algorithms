package AcmicpcNet.Silver.N9465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T ; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];

            for (int i = 0; i < 2; i++) {
                System.arraycopy(
                    Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                    0,
                    arr[i],
                    0,
                    n
                );
            }

            int[][] dp = new int[2][n];

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for (int i = 1; i < n; i++) {
                int j = 0;
                if (i >= 2) {
                    j = Math.max(dp[0][i-2], dp[1][i-2]);
                }
                dp[0][i] = arr[0][i] + Math.max(j, dp[1][i-1]);
                dp[1][i] = arr[1][i] + Math.max(j, dp[0][i-1]);
            }

            int ans = Math.max(dp[0][n-1], dp[1][n-1]);

            bw.write(String.valueOf(ans) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
