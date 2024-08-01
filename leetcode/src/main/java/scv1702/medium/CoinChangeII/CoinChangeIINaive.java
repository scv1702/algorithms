package scv1702.medium.CoinChangeII;

import java.util.Arrays;

public class CoinChangeIINaive {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        if (amount == 0)
            return 1;
        if (coins[0] >= amount)
            return coins[0] == amount ? 1 : 0;
        int[][] lookup = new int[amount + 1][coins.length];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (i == coins[j]) {
                        lookup[i][j] += 1;
                        continue;
                    }
                    // i = coins[j] + (coins[j]보다 크거나 같은 수들)
                    for (int k = j; k < coins.length; k++) {
                        lookup[i][j] += lookup[i - coins[j]][k];
                    }
                }
            }
        }
        return sum(lookup[amount]);
    }

    public int sum(int[] arr) {
        int res = 0;
        for (int e : arr) {
            res += e;
        }
        return res;
    }
}
