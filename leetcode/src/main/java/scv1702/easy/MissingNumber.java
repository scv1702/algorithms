package scv1702.easy;

public class MissingNumber {
    public String debug(long n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            sb.append(1 & n);
            n >>>= 1;
        }
        return sb.reverse().toString();
    }

    public int missingNumber(int[] nums) {
        long[] visited = new long[nums.length / 64 + nums.length % 64];
        for (int num : nums) {
            visited[num / 64] |= 1L << (num % 64);
        }
        int vi = 0;
        int ans = 0;
        while (vi < visited.length) {
            for (int i = 0; i < 64; i++) {
                if ((1L & visited[vi]) == 1) {
                    visited[vi] >>>= 1;
                    ans += 1;
                } else {
                    return ans;
                }
            }
            vi += 1;
        }
        return ans;
    }
}
