package AcmicpcNet.Gold.N14442;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0]; // 구간 개수
        int M = line[1];
        int K = line[2];

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine()
                .chars()
                .map(n -> n - '0')
                .toArray();
        }

        int answer = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][1+K];

        visited[0][0][K] = true;
        queue.offer(new int[] { 0, 0, 1, K });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int d = curr[2];
            int k = curr[3];
            if (i == N-1 && j == M-1) {
                answer = d;
                break;
            }
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                int nd = d + 1;
                if (ni < 0 || ni >= N) continue;
                if (nj < 0 || nj >= M) continue;
                if (map[ni][nj] == 1 && k > 0 && !visited[ni][nj][k-1]) {
                    visited[ni][nj][k-1] = true;
                    queue.offer(new int[] { ni, nj, nd, k-1 });
                }
                if (map[ni][nj] == 0 && !visited[ni][nj][k] ) {
                    visited[ni][nj][k] = true;
                    queue.offer(new int[] { ni, nj, nd, k });
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
