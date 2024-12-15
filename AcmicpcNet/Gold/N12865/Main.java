package AcmicpcNet.Gold.N12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int K = line[1];

        int[][] arr = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            arr[i][0] = line[0];
            arr[i][1] = line[1];
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int w = arr[i][0];
                int v = arr[i][1];

                dp[i][j] = dp[i-1][j];
                if (w <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w] + v);
                }
            }
        }

        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
        bw.close();
    }
}
