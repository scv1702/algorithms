package AcmicpcNet.Gold.N2573;

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

    private static int solve(int[][] B) {
        int N = B.length;
        int M = B[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (B[i][j] > 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int res = 1;
        while (!queue.isEmpty()) {
            Queue<int[]> next = new ArrayDeque<>();
            int[][] nextB = new int[N][M];

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                int cnt = 0;
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (B[ni][nj] == 0) {
                        cnt += 1;
                    }
                }

                nextB[i][j] = Math.max(0, B[i][j] - cnt);
                if (nextB[i][j] > 0) {
                    next.offer(new int[] { i, j });
                }
            }

            if (next.size() <= 1) {
                return 0;
            }
            if (isBreak(nextB, next.peek())) {
                return res;
            }

            queue = next;
            B = nextB;
            res += 1;
        }

        return 0;
    }

    private static boolean isBreak(int[][] B, int[] start) {
        int N = B.length;
        int M = B[0].length;
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (B[ni][nj] == 0) continue;
                if (visited[ni][nj]) continue;
                visited[ni][nj] = true;
                queue.offer(new int[] { ni, nj });
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (B[i][j] > 0 && !visited[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            B[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int ans = solve(B);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
