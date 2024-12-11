package AcmicpcNet.Silver.N21736;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    private static final int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(
                br.readLine().toCharArray(),
                0,
                arr[i],
                0,
                M
            );
        }

        int[] s = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'I') {
                    s[0] = i;
                    s[1] = j;
                    break;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        int res = 0;

        visited[s[0]][s[1]] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            if (arr[n[0]][n[1]] == 'P') {
                res += 1;
            }
            for (int[] dir : dirs) {
                int[] next = new int[2];
                next[0] = n[0] + dir[0];
                next[1] = n[1] + dir[1];
                if (next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= M) continue;
                if (arr[next[0]][next[1]] == 'X') continue;
                if (visited[next[0]][next[1]]) continue;
                visited[next[0]][next[1]] = true;
                queue.offer(next);
            }
        }

        String ans = res > 0 ? String.valueOf(res) : "TT";

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
