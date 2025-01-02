package AcmicpcNet.Gold.N7579;

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

        int[] bytes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] prices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[1 + 10_000][N];
        int L = dp.length;

        for (int i = 0; i < L; i++) {
            int price = prices[0];
            if (i >= price) {
                dp[i][0] = bytes[0];
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 1; j < N; j++) {
                int price = prices[j];
                if (i < price) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i-price][j-1] + bytes[j],
                        dp[i][j-1]
                    );
                }
            }
        }

        int cost = 0;
        for (int i = 0; i < L; i++) {
            if (dp[i][N-1] >= M) {
                cost = i;
                break;
            }
        }

        bw.write(String.valueOf(cost));
        bw.flush();
        bw.close();
    }
}
