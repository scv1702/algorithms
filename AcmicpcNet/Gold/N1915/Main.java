package AcmicpcNet.Gold.N1915;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(
                br.readLine().chars().map(n -> n - '0').toArray(),
                0,
                arr[i],
                0,
                M
            );
        }

        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            dp[i][0] = arr[i][0];
        }
        for (int j = 0; j < M; j++) {
            dp[0][j] = arr[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int prev = dp[i-1][j-1];
                    if (arr[i-prev][j-prev] == 1 &&
                        dp[i][j-1] == prev &&
                        dp[i-1][j] == prev) {
                        dp[i][j] = prev + 1;
                    } else {
                        prev = Math.min(dp[i-1][j], dp[i][j-1]);
                        if (arr[i-prev][j-prev] == 1) {
                            dp[i][j] = prev + 1;
                        } else {
                            dp[i][j] = prev;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        bw.write(String.valueOf(ans * ans));
        bw.flush();
        bw.close();
    }
}
