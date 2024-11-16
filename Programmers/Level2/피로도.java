import java.util.*;

class Solution {

    private int ans = 0;

    private void permutate(
        int[][] dungeons,
        int k,
        int[] ids,
        boolean[] visited,
        int depth
    ) {
        int n = dungeons.length;
        if (depth >= n) {
            int f = k;
            int d = 0;
            for (int i = 0; i < n; i++) {
                int id = ids[i];
                if (f < dungeons[id][0]) {
                    break;
                }
                f -= dungeons[id][1];
                d += 1;
            }
            ans = Math.max(ans, d);
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ids[depth] = i;
                permutate(dungeons, k, ids, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int[] ids = new int[n];
        boolean[] visited = new boolean[n];
        permutate(dungeons, k, ids, visited, 0);
        return ans;
    }
}