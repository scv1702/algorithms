import java.util.*;

class Solution {

    private String answer = null;
    private char[] sb = null;
    private int[][] dirs = {
        {1, 0}, {0, -1}, {0, 1}, {-1, 0}
    };

    private char convert(int d) {
        return "dlru".charAt(d);
    }

    private int distance(int a, int b, int c, int d) {
        return Math.abs(a - c) + Math.abs(b - d);
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int depth, int k) {
        if (answer != null) {
            return ;
        }

        if (depth + distance(x, y, r, c) > k) {
            return ;
        }

        if (depth == k) {
            answer = new String(sb);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < 1 || nx > n) continue;
            if (ny < 1 || ny > m) continue;
            sb[depth] = convert(i);
            dfs(n, m, nx, ny, r, c, depth + 1, k);
        }
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dis = distance(x, y, r, c);

        if (k < dis || Math.abs(dis - k) % 2 != 0) {
            return "impossible";
        }

        sb = new char[k];
        dfs(n, m, x, y, r, c, 0, k);

        return answer;
    }
}