package scv1702.medium;

import java.util.HashMap;
import java.util.Map;

public class PowXN {
    Map<Long, Double> lookup;

    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (x == 1 || n == 0)
            return 1;
        lookup = new HashMap<>();
        return helper(x, Math.abs((long) n), n > 0);
    }

    // n is even: helper(x, n) = helper(x, n/2) * helper(x, n/2)
    // n is odd: helper(x, n) = helper(x, (n-1)/2) * helper(x, (n-1)/2) * x
    public double helper(double x, long n, boolean pos) {
        if (n == 0)
            return 1.0;
        if (n == 1) {
            if (pos)
                return x;
            else
                return 1.0 / x;
        }
        if (!lookup.containsKey(n)) {
            double res = 0;
            if (n % 2 == 0) {
                res = helper(x, n / 2, pos) * helper(x, n / 2, pos);
            } else {
                res = helper(x, (n - 1) / 2, pos) * helper(x, (n - 1) / 2, pos);
                if (pos)
                    res *= x;
                else
                    res *= 1.0 / x;
            }
            lookup.put(n, res);
        }
        return lookup.get(n);
    }
}
