package AcmicpcNet.Gold.N15684;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int RIGHT = 1;

    private static boolean possible(int[][] L) {
        int H = L.length;
        int N = L[0].length;

        for (int j = 0; j < N; j++) {
            int pos = j;
            for (int i = 0; i < H; i++) {
                if (L[i][pos] == RIGHT) {
                    pos += 1;
                } else if (pos >= 1 && L[i][pos-1] == RIGHT) {
                    pos -= 1;
                }
            }
            if (pos != j) return false;
        }

        return true;
    }

    private static int ans = Integer.MAX_VALUE;

    private static void comb(int[][] L, int n, int r, int depth, int prev) {
        int N = L[0].length;

        if (possible(L)) {
            ans = Math.min(ans, depth);
        }

        if (depth == r) {
            return ;
        }

        for (int i = prev; i < n; i++) {
            int a = i / N;
            int b = i % N;
            if (b == N-1) continue;
            if (L[a][b] > 0 || L[a][b+1] > 0) continue;
            L[a][b] = RIGHT;
            comb(L, n, r, depth + 1, i + 1);
            L[a][b] = 0;
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
        int H = line[2];

        int[][] L = new int[H][N];
        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int a = line[0] - 1;
            int b = line[1] - 1;
            L[a][b] = RIGHT;
        }

        comb(L, N * H, 3, 0, 0);

        if (ans > 3) {
            ans = -1;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
