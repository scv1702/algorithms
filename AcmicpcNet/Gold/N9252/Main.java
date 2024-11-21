package AcmicpcNet.Gold.N9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int[][] dirs = {
        { 0, -1 }, { -1, -1 }, { -1, 0 }
    };

    private static final int LEFT = 0;
    private static final int DIAGONAL = 1;
    private static final int UP = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();

        int N = A.length();
        int M = B.length();

        int[][] dp = new int[1+N][1+M];
        int[][] prev = new int[1+N][1+M];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    prev[i][j] = DIAGONAL;
                } else {
                    if (dp[i-1][j] < dp[i][j-1]) {
                        dp[i][j] = dp[i][j-1];
                        prev[i][j] = LEFT;
                    } else {
                        dp[i][j] = dp[i-1][j];
                        prev[i][j] = UP;
                    }
                }
            }
        }

        int i = N;
        int j = M;

        while (i >= 1 && j >= 1) {
            if (A.charAt(i-1) == B.charAt(j-1)) {
                sb.append(A.charAt(i-1));
            }
            int ni = i + dirs[prev[i][j]][0];
            int nj = j + dirs[prev[i][j]][1];
            i = ni;
            j = nj;
        }

        bw.write(String.valueOf(dp[N][M]) + '\n');
        if (!sb.isEmpty()) {
            bw.write(sb.reverse().toString() + '\n');
        }

        bw.flush();
        bw.close();
    }
}
