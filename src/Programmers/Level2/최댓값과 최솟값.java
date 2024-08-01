import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        String answer = String.format("%d %d", min, max);
        return answer;
    }
}
