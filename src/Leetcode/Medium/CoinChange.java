package Leetcode.Medium;

import java.util.Arrays;

public class CoinChange {
    int[] lookup;
    final int INF = 987654321;

    public int coinChange(int[] coins, int amount) {
        lookup = new int[amount + 1];
        Arrays.fill(lookup, INF);
        lookup[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                lookup[i] = Math.min(lookup[i], lookup[i - coin] + 1);
            }
        }
        return lookup[amount] == INF ? -1 : lookup[amount];
    }
}
