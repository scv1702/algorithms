package Leetcode.Medium.CoinChangeII;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] lookup = new int[amount + 1];
        lookup[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    lookup[i] += lookup[i - coin];
                }
            }
        }
        return lookup[amount];
    }
}
