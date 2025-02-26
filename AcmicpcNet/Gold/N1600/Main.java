package AcmicpcNet.Gold.N1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    private static final int[][] dirs = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };

    private static final int[][] jumps = {
        { -1, -2 },
        { -2, -1 },
        { -2, 1 },
        { -1, 2 },
        { 1, 2 },
        { 2, 1 },
        { 2, -1 },
        { 1, -2 }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int W = line[0]; // 가로 길이
        int H = line[1]; // 세로 길이
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int answer = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[H][W][1+K];
        visited[0][0][K] = true;
        queue.offer(new int[] { 0, 0, 0, K });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int d = curr[2];
            int k = curr[3];

            if (i == H-1 && j == W-1) {
                answer = d;
                break;
            }

            if (k > 0) {
                for (int[] jump : jumps) {
                    int ni = i + jump[0];
                    int nj = j + jump[1];
                    if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                    if (visited[ni][nj][k-1]) continue;
                    if (map[ni][nj] > 0) continue;
                    visited[ni][nj][k-1] = true;
                    queue.offer(new int[] { ni, nj, d + 1, k - 1 });
                }
            }

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                if (visited[ni][nj][k]) continue;
                if (map[ni][nj] > 0) continue;
                visited[ni][nj][k] = true;
                queue.offer(new int[] { ni, nj, d + 1, k });
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
