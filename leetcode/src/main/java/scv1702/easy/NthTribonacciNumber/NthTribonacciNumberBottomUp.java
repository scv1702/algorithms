package scv1702.easy.NthTribonacciNumber;

public class NthTribonacciNumberBottomUp {
    public int tribonacci(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;
        int i = 0; int j = 1; int k = 1;
        int res = i + j + k;
        for (int m = 4; m <= n; m++) {
            i = j; j = k; k = res;
            res = i + j + k;
        }
        return res;
    }
}