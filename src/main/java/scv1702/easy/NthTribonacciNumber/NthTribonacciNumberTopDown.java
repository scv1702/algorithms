package scv1702.easy.NthTribonacciNumber;

public class NthTribonacciNumberTopDown {
    public int tribonacci(int n) {
        int[] lookup = new int[n+1];
        return recur(n, lookup);
    }

    public int recur(int n, int[] lookup) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;
        if (lookup[n] > 0) return lookup[n];
        lookup[n] = recur(n-3, lookup) + recur(n-2, lookup) + recur(n-1, lookup);
        return lookup[n];
    }
}
