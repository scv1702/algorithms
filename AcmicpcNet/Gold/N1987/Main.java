package AcmicpcNet.Gold.N1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int answer = 0;

    private static final int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    private static void dfs(char[][] arr, boolean[] visited, int r, int c, int depth) {
        int R = arr.length;
        int C = arr[0].length;

        int idx = arr[r][c] - 'A';
        visited[idx] = true;
        answer = Math.max(answer, depth);

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            int nidx = arr[nr][nc] - 'A';
            if (visited[nidx]) continue;
            dfs(arr, visited, nr, nc, depth + 1);
            visited[nidx] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int R = line[0];
        int C = line[1];

        char[][] arr = new char[R][C];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            System.arraycopy(
                br.readLine().toCharArray(),
                0,
                arr[i],
                0,
                C
            );
        }

        dfs(arr, visited, 0, 0, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
