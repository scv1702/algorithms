package AcmicpcNet.Gold.N11559;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void logs(char[][] fields) {
        for (char[] field : fields) {
            System.out.println(Arrays.toString(field));
        }
        System.out.println();
    }

    private static final int[][] dirs = {
        {0, 1}, {1, 0}, {0 ,-1}, {-1, 0}
    };

    public static void visit(char[][] fields, boolean[][] visited, int i, int j) {
        int N = fields.length;
        int M = fields[0].length;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
            if (fields[i][j] == fields[ni][nj] && !visited[ni][nj]) {
                visit(fields, visited, ni, nj);
            }
        }
    }

    public static int count(boolean[][] visited) {
        int N = visited.length;
        int M = visited[0].length;
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    res += 1;
                }
            }
        }

        return res;
    }

    public static void bomb(char[][] fields, boolean[][] visited) {
        int N = fields.length;
        int M = fields[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    fields[i][j] = '.';
                }
            }
        }
    }

    public static boolean resolve(char[][] fields) {
        int N = fields.length;
        int M = fields[0].length;

        boolean res = false;
        for (int j = 0; j < M; j++) {
            Queue<Character> queue = new ArrayDeque<>();
            int i = 0;
            for (i = N-1; i >= 0; i--) {
                if (fields[i][j] == '.') continue;
                queue.offer(fields[i][j]);
                fields[i][j] = '.';
            }
            i = N-1;
            while (i >= 0 && !queue.isEmpty()) {
                fields[i][j] = queue.poll();
                i -= 1;
                res = true;
            }
        }

        return res;
    }

    private static int ans = 0;
    public static void play(char[][] fields) {
        int N = fields.length;
        int M = fields[0].length;
        boolean bombed = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (fields[i][j] == '.') continue;
                boolean[][] visited = new boolean[N][M];
                visit(fields, visited, i, j);
                if (count(visited) >= 4) {
                    bomb(fields, visited);
                    bombed = true;
                }
            }
        }

        if (bombed) {
            ans += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 12;
        int M = 6;
        char[][] fields = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                fields[i][j] = line.charAt(j);
            }
        }

        int prev = 0;
        while (true) {
            play(fields);
            resolve(fields);
            if (prev == ans) {
                break;
            }
            prev = ans;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
