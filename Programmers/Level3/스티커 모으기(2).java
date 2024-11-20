import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if (n <= 3) {
            return Arrays.stream(sticker)
                .max()
                .orElse(0);
        }

        int[] dp = new int[n];

        dp[0] = sticker[0];
        dp[1] = Math.max(dp[0], sticker[1]);

        for (int i = 2; i < n-1; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }

        int answer = dp[n-2];

        dp[1] = sticker[1];
        dp[2] = Math.max(dp[1], sticker[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }

        answer = Math.max(answer, dp[n-1]);

        return answer;
    }
}