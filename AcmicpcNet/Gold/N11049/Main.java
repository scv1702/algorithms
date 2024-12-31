package AcmicpcNet.Gold.N11049;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static int dfs(int[][] arr, int[][] dp, int left, int right) {
        if (left == right) {
            return 0;
        }

        if (dp[left][right] >= 0) {
            return dp[left][right];
        }

        int res = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            res = Math.min(res, dfs(arr, dp, left, i) + dfs(arr, dp, i + 1, right) + arr[left][0] * arr[i][1] * arr[right][1]);
        }

        return dp[left][right] = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int r = line[0];
            int c = line[1];
            arr[i][0] = r;
            arr[i][1] = c;
        }

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        String answer = String.valueOf(dfs(arr, dp, 0, N-1));

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
