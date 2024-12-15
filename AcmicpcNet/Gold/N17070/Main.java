package AcmicpcNet.Gold.N17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;
    private static final int DIAGONAL = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                arr[i],
                0,
                N
            );
        }

        int[][][] dp = new int[N][N][3];

        for (int j = 1; j < N; j++) {
            if (arr[0][j] == 1) break;
            dp[0][j][WIDTH] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == 1) continue;

                if (arr[i][j-1] == 0) {
                    dp[i][j][WIDTH] = dp[i][j-1][WIDTH] + dp[i][j-1][DIAGONAL];
                }

                if (arr[i-1][j] == 0) {
                    dp[i][j][HEIGHT] = dp[i-1][j][HEIGHT] + dp[i-1][j][DIAGONAL];
                }

                if (arr[i-1][j-1] == 0 && arr[i][j-1] == 0 && arr[i-1][j] == 0) {
                    dp[i][j][DIAGONAL] = dp[i-1][j-1][WIDTH] + dp[i-1][j-1][HEIGHT] + dp[i-1][j-1][DIAGONAL];
                }
            }
        }

        int ans = dp[N-1][N-1][WIDTH] + dp[N-1][N-1][HEIGHT] + dp[N-1][N-1][DIAGONAL];

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
