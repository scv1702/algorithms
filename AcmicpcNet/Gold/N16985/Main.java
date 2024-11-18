package AcmicpcNet.Gold.N16985;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final int N = 5;
    private static final int[][] dirs = {
        {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}
    };

    public static int[][] rotateToRight(int[][] maze) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[j][N-1-i] = maze[i][j];
            }
        }
        return res;
    }

    public static void permute(
        List<int[]> result,
        int[] ids,
        boolean[] visited,
        int depth
    ) {
        int n = ids.length;

        if (depth >= n) {
            result.add(ids.clone());
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            ids[depth] = i;
            visited[i] = true;
            permute(result, ids, visited, depth + 1);
            visited[i] = false;
        }
    }

    public static void permuteWithDupplication(
        List<int[]> result,
        int[] ids,
        int depth
    ) {
        int n = ids.length;

        if (depth >= n) {
            result.add(ids.clone());
            return ;
        }

        for (int i = 0; i < 4; i++) {
            ids[depth] = i;
            permuteWithDupplication(result, ids, depth + 1);
        }
    }

    public static int[][] clone(int[][] array) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = array[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][][] maze = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.arraycopy(
                    Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                    0,
                    maze[i][j],
                    0,
                    N
                );
            }
        }

        List<int[]> result = new ArrayList<>();
        permute(result, new int[N], new boolean[N], 0);

        List<int[]> rotates = new ArrayList<>();
        permuteWithDupplication(rotates, new int[N], 0);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < rotates.size(); j++) {
                int[][][] permutedMaze = new int[N][N][N];

                for (int k = 0; k < N; k++) {
                    permutedMaze[k] = clone(maze[result.get(i)[k]]);
                    for (int m = 0; m < rotates.get(j)[k]; m++) {
                        permutedMaze[k] = rotateToRight(permutedMaze[k]);
                    }
                }

                if (permutedMaze[0][0][0] == 0 || permutedMaze[N-1][N-1][N-1] == 0) continue;

                boolean[][][] visited = new boolean[N][N][N];
                Queue<int[]> queue = new ArrayDeque<>();

                visited[0][0][0] = true;
                queue.offer(new int[] { 0, 0, 0, 0 });

                int distance = Integer.MAX_VALUE;

                while (!queue.isEmpty()) {
                    int[] u = queue.poll();
                    int ui = u[0];
                    int uj = u[1];
                    int uk = u[2];
                    int d = u[3];
                    if (ui == N-1 && uj == N-1 && uk == N-1) {
                        distance = d;
                        break;
                    }
                    for (int[] dir : dirs) {
                        int vi = ui + dir[0];
                        int vj = uj + dir[1];
                        int vk = uk + dir[2];
                        if (vi < 0 || vi >= N) continue;
                        if (vj < 0 || vj >= N) continue;
                        if (vk < 0 || vk >= N) continue;
                        if (visited[vi][vj][vk]) continue;
                        if (permutedMaze[vi][vj][vk] == 0) continue;
                        visited[vi][vj][vk] = true;
                        queue.offer(new int[] { vi, vj, vk, d + 1 });
                    }
                }

                ans = Math.min(ans, distance);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
        bw.close();
    }
}
