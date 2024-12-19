package AcmicpcNet.Gold.N2638;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final int[][] dirs = {
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    private static final int OUTSIDE_AIR = 0;
    private static final int CHEESE = 1;
    private static final int INSIDE_AIR = 2;

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void penetrate(int[][] cheese) {
        int N = cheese.length;
        int M = cheese[0].length;
        boolean[][] visited = new boolean[N][M];
        penetrateInternal(cheese, visited, 0, 0);
    }

    private static void penetrateInternal(int[][] cheese, boolean[][] visited, int i, int j) {
        int N = cheese.length;
        int M = cheese[0].length;
        visited[i][j] = true;
        cheese[i][j] = OUTSIDE_AIR;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= N) continue;
            if (nj < 0 || nj >= M) continue;
            if (cheese[ni][nj] == CHEESE) continue;
            if (visited[ni][nj]) continue;
            penetrateInternal(cheese, visited, ni, nj);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[][] cheese = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                0,
                cheese[i],
                0,
                M
            );
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == CHEESE) {
                    cnt += 1;
                } else {
                    cheese[i][j] = INSIDE_AIR;
                }
            }
        }

        int t = 0;
        penetrate(cheese);

        while (cnt > 0) {
            print(cheese);

            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if (cheese[i][j] != CHEESE) continue;
                    int air = 0;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni < 0 || ni >= N) continue;
                        if (nj < 0 || nj >= M) continue;
                        if (cheese[ni][nj] == OUTSIDE_AIR) air += 1;
                    }
                    if (air >= 2) {
                        queue.offer(new int[] { i, j });
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int i = tuple[0];
                int j = tuple[1];
                cheese[i][j] = OUTSIDE_AIR;
                cnt -= 1;
            }

            penetrate(cheese);

            t += 1;
        }

        bw.write(String.valueOf(t));
        bw.flush();
        bw.close();
    }
}
