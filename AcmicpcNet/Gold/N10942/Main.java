package AcmicpcNet.Gold.N10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
            if (i+1 < N && A[i] == A[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for (int k = 2; k < N; k++) {
            int i = 0;
            int j = k;
            for (; i < N && j < N; i++, j++) {
                if (A[i] == A[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            int[] Q = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int S = Q[0] - 1;
            int E = Q[1] - 1;
            bw.write(String.valueOf(dp[S][E]) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
