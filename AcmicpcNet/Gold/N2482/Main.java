package AcmicpcNet.Gold.N2482;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (N/2 < K) {
            bw.write("0");
            bw.flush();
            bw.close();
            return ;
        }

        int[][][] dp = new int[K+1][N][2];

        for (int j = 0; j < N; j++) {
            dp[1][j][0] = 1;
            dp[1][j][1] = j;
        }

        for (int i = 2; i <= K; i++) {
            dp[i][2*i-2][0] = 1;
            for (int j = 2*i-1; j < N-1; j++) {
                dp[i][j][0] = (dp[i][j-1][0] + dp[i-1][j-2][0]) % MOD;
            }
            dp[i][2*i-1][1] = 1;
            for (int j = 2*i; j < N-1; j++) {
                dp[i][j][1] = (dp[i][j-1][1] + dp[i-1][j-2][1]) % MOD;
            }
            dp[i][N-1][0] = dp[i][N-2][0];
            dp[i][N-1][1] = (dp[i][N-2][1] + dp[i-1][N-3][1]) % MOD;
        }

        int ans = (dp[K][N-1][0] + dp[K][N-1][1]) % MOD;

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
