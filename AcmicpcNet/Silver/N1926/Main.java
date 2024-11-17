package AcmicpcNet.Silver.N1926;

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

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = line[0];
        int m = line[1];

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.arraycopy(line, 0, map[i], 0, m);
        }

        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        int maxArea = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] != 1) continue;
                int area = 1;
                visited[i][j] = true;
                queue.offer(new int[] {i * m + j});
                while (!queue.isEmpty()) {
                    int[] tuple = queue.poll();
                    int u = tuple[0];
                    int ui = u / m;
                    int uj = u % m;
                    for (int[] dir : dirs) {
                        int vi = ui + dir[0];
                        int vj = uj + dir[1];
                        if (vi < 0 || vi >= n || vj < 0 || vj >= m) continue;
                        if (visited[vi][vj]) continue;
                        if (map[vi][vj] != 1) continue;
                        visited[vi][vj] = true;
                        area += 1;
                        queue.offer(new int[] {vi * m + vj});
                    }
                }
                maxArea = Math.max(maxArea, area);
                count += 1;
            }
        }

        bw.write(String.valueOf(count) + '\n');
        bw.write(String.valueOf(maxArea) + '\n');
        bw.flush();
        bw.close();
    }
}
