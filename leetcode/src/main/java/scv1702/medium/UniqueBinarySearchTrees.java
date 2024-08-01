package scv1702.medium;

public class UniqueBinarySearchTrees {
    int[][] lookup;

    public int numTrees(int n) {
        lookup = new int[n + 1][n + 1];
        return helper(1, n);
    }

    public int helper(int i, int j) {
        if (i >= j)
            return 1;
        if (lookup[i][j] > 0)
            return lookup[i][j];
        int res = 0;
        for (int k = i - 1; k < j; k++) {
            res += helper(i, k) * helper(k + 2, j);
        }
        lookup[i][j] = res;
        return res;
    }
}
