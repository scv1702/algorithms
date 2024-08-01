package scv1702.easy;

public class ClimbingStairs {
    int[] lookup;

    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        lookup = new int[n + 1];
        return helper(n);
    }

    // lookup(n) = lookup(n-1) + lookup(n-2)
    public int helper(int n) {
        if (n <= 2)
            return n;
        if (lookup[n] <= 0) {
            lookup[n] = helper(n - 1) + helper(n - 2);
        }
        return lookup[n];
    }
}
