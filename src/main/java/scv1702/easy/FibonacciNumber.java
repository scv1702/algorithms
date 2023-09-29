package scv1702.easy;

public class FibonacciNumber {
    int[] lookup;

    public int fib(int n) {
        if (n <= 1)
            return n;
        lookup = new int[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (lookup[n] <= 0) {
            lookup[n] = helper(n - 1) + helper(n - 2);
        }
        return lookup[n];
    }
}
