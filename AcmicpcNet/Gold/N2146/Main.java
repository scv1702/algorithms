package AcmicpcNet.Gold.N2146;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    private static final int[][] dirs = {
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    private static void dfs(int[][] A, boolean[][] visited, int start, int color) {
        int N = A.length;
        int i = start / N;
        int j = start % N;

        if (visited[i][j]) return ;

        visited[i][j] = true;
        A[i][j] = color;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
            if (A[ni][nj] == 0) continue;
            if (visited[ni][nj]) continue;
            dfs(A, visited, ni * N + nj, color);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            A[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        boolean[][] visited = new boolean[N][N];
        int color = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                if (A[i][j] == 0) continue;
                dfs(A, visited, i * N + j, color);
                color += 1;
            }
        }

        Queue<int[]> beaches = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0) continue;
                boolean found = false;
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
                    if (A[ni][nj] == 0) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    beaches.offer(new int[] { i, j });
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while (!beaches.isEmpty()) {
            int[] start = beaches.poll();
            int si = start[0];
            int sj = start[1];

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] { si, sj, 0 });
            visited = new boolean[N][N];
            visited[si][sj] = true;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                int k = curr[2];
                if (A[i][j] > 0 && A[i][j] != A[si][sj]) {
                    ans = Math.min(ans, k - 1);
                    break;
                }
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
                    if (A[ni][nj] == A[si][sj]) continue;
                    if (visited[ni][nj]) continue;
                    visited[ni][nj] = true;
                    queue.offer(new int[] { ni, nj, k + 1 });
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
