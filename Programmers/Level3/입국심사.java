import java.util.*;

class Solution {

    public boolean check(int n, int[] times, long t) {
        long s = 0;
        for (int i = 0; i < times.length; i++) {
            s += t / times[i];
        }
        return s >= n;
    }

    public long solution(int n, int[] times) {
        long left = 1;
        long right = 1_000_000_000L * 1_000_000_000L;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (!check(n, times, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}