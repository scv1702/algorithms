import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j-1 >= 0) {
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] += triangle[i][j];
            }
        }
        return Arrays.stream(dp[n-1])
                .max()
                .orElse(0);
    }
}