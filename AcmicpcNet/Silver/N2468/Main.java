package AcmicpcNet.Silver.N2468;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                map[i],
                0,
                N
            );
        }

        int MAX_HEIGHT = 1;
        for (int i = 0; i < N; i++) {
            int maxHeight = Arrays.stream(map[i])
                .max()
                .orElse(0);
            MAX_HEIGHT = Math.max(MAX_HEIGHT, maxHeight);
        }

        int ans = 0;
        int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        for (int h = 0; h <= MAX_HEIGHT; h++) {
            int area = 0;
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (map[i][j] <= h) continue;
                    area += 1;
                    visited[i][j] = true;
                    queue.offer(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] tuple = queue.poll();
                        int ui = tuple[0];
                        int uj = tuple[1];
                        for (int[] dir : dirs) {
                            int vi = ui + dir[0];
                            int vj = uj + dir[1];
                            if (vi < 0 || vi >= N || vj < 0 || vj >= N) continue;
                            if (visited[vi][vj]) continue;
                            if (map[vi][vj] <= h) continue;
                            visited[vi][vj] = true;
                            queue.offer(new int[] { vi, vj });
                        }
                    }
                }
            }
            System.out.printf("%d %d\n", h, area);
            ans = Math.max(ans, area);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
