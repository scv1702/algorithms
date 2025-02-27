package AcmicpcNet.Gold.N16932;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static Map<Integer, Integer> sizes = new HashMap<>();
    private static int[][] C;
    private static final int[][] dirs = {
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    private static int dfs(int[][] map, boolean[][] visited, int i, int j, int k) {
        int N = map.length;
        int M = map[0].length;

        visited[i][j] = true;
        C[i][j] = k;

        int size = 1;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
            if (visited[ni][nj]) continue;
            if (map[ni][nj] == 0) continue;
            size += dfs(map, visited, ni, nj, k);
        }

        return size;
    }

    private static int bfs(int[][] map, boolean[][] visited, int i, int j, int k) {
        int N = map.length;
        int M = map[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        visited[i][j] = true;
        C[i][j] = k;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];
                if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                if (visited[ni][nj]) continue;
                if (map[ni][nj] == 0) continue;
                visited[ni][nj] = true;
                C[ni][nj] = k;
                size += 1;
                queue.offer(new int[] { ni, nj });
            }
        }

        return size;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        C = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int k = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 0) continue;
                int size = bfs(map, visited, i, j, k);
                sizes.put(k, size);
                k += 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) continue;
                int size = 1;
                Set<Integer> set = new HashSet<>();
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                    if (map[ni][nj] == 0) continue;
                    if (set.contains(C[ni][nj])) continue;
                    size += sizes.get(C[ni][nj]);
                    set.add(C[ni][nj]);
                }
                answer = Math.max(answer, size);
            }
        }

        if (answer == 0) {
            answer = N * M;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
