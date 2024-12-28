package AcmicpcNet.Gold.N2342;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int INF = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] opcodes = new int[line.length];
        System.arraycopy(
            line, 0, opcodes, 1, line.length - 1
        );

        int[][] W = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                W[i][j] = INF;
            }
        }

        for (int i = 1; i < 5; i++) {
            W[0][i] = 2;
        }

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (i == j) {
                    W[i][j] = 1;
                } else if (Math.abs(i-j) == 1 || Math.abs(i-j) == 3) {
                    W[i][j] = 3;
                } else if (Math.abs(i-j) == 2) {
                    W[i][j] = 4;
                }
            }
        }

        int N = opcodes.length;
        int[][][] dp = new int[N][5][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 1; i < N; i++) {
            int now = opcodes[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][now] = Math.min(dp[i][j][now], dp[i-1][j][k] + W[k][now]);
                    dp[i][now][j] = Math.min(dp[i][now][j], dp[i-1][k][j] + W[k][now]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[N-1][i][j]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
