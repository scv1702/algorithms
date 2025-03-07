package AcmicpcNet.Gold.N20166;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int[][] dirs = {
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, - 1 },
        { 0, -1 },
        { -1, -1 },
        { -1, 0 },
        { -1, 1 }
    };

    private static int[][][] mem;

    private static int dfs(
        char[][] C,
        String s,
        int r,
        int c,
        int depth
    ) {
        int N = C.length;
        int M = C[0].length;
        int L = s.length();

        if (s.charAt(depth) != C[r][c]) return 0;

        if (depth == L-1) {
            return 1;
        }

        if (mem[r][c][depth] >= 0) {
            return mem[r][c][depth];
        }

        int res = 0;
        for (int[] dir : dirs) {
            int nr = r;
            int nc = c;
            if (dir[0] >= 0) {
                nr = (nr + dir[0]) % N;
            } else {
                nr = (nr + N + dir[0]) % N;
            }
            if (dir[1] >= 0) {
                nc = (nc + dir[1]) % M;
            } else {
                nc = (nc + M + dir[1]) % M;
            }
            res += dfs(C, s, nr, nc, depth+1);
        }

        return mem[r][c][depth] = res;
    }

    private static int solve(char[][] C, String s) {
        int N = C.length;
        int M = C[0].length;
        int L = s.length();
        int res = 0;
        mem = new int[N][M][L];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res += dfs(C, s, i, j, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];
        int K = line[2];

        char[][] C = new char[N][M];
        for (int i = 0; i < N; i++) {
            C[i] = br.readLine().toCharArray();
        }

        for (int k = 0; k < K; k++) {
            String s = br.readLine();
            int res = solve(C, s);
            bw.write(String.format("%d\n", res));
        }

        bw.flush();
        bw.close();
    }
}
