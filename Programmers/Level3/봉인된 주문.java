import java.util.*;

class Solution {

    private String convert(long n) {
        StringBuilder sb = new StringBuilder();
        long d = n;
        while (d > 0) {
            d -= 1;
            sb.append((char) ('a' + (d % 26)));
            d /= 26L;
        }
        sb.reverse();
        return sb.toString();
    }

    public long convert(String s) {
        long res = 0L;
        for (int i = s.length() - 1; i >= 0; i--) {
            int d = s.length() - 1 - i;
            res += Math.pow(26L, d) * (s.charAt(i) - 'a' + 1);
        }
        return res;
    }

    public String solution(long n, String[] bans) {
        long[] _bans = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            _bans[i] = convert(bans[i]);
        }
        Arrays.sort(_bans);
        long now = n;
        for (int i = 0; i < bans.length; i++) {
            if (_bans[i] <= now) {
                now += 1L;
            } else {
                break;
            }
        }
        return convert(now);
    }
}