package AcmicpcNet.Gold.N2239;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static boolean found = false;
    public static void dfs(int[][] sudoku, boolean[][] row, boolean[][] col, boolean[][] sub, int n) {
        if (found) {
            return ;
        }

        int N = sudoku.length;

        if (n >= N * N) {
            found = true;
            return ;
        }

        int r = n / N;
        int c = n % N;

        if (sudoku[r][c] > 0) {
            dfs(sudoku, row, col, sub, n + 1);
            return;
        }

        for (int k = 1; k <= 9; k++) {
            if (!row[r][k] && !col[c][k] && !sub[3 * (r/3) + (c/3)][k]) {
                sudoku[r][c] = k;
                row[r][k] = true;
                col[c][k] = true;
                sub[3 * (r/3) + (c/3)][k] = true;
                dfs(sudoku, row, col, sub, n + 1);
                if (found) {
                    return ;
                }
                sudoku[r][c] = 0;
                row[r][k] = false;
                col[c][k] = false;
                sub[3 * (r/3) + (c/3)][k] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 9;
        int[][] sudoku = new int[N][N];

        boolean[][] row = new boolean[N][10];
        boolean[][] col = new boolean[N][10];
        boolean[][] sub = new boolean[N][10];

        for (int i = 0; i < N; i++) {
            int[] line = br.readLine().chars()
                .map(c -> c - '0')
                .toArray();
            System.arraycopy(
                line,
                0,
                sudoku[i],
                0,
                N
            );
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sudoku[i][j] > 0) {
                    row[i][sudoku[i][j]] = true;
                    col[j][sudoku[i][j]] = true;
                    sub[3 * (i/3) + (j/3)][sudoku[i][j]] = true;
                }
            }
        }

        dfs(sudoku, row, col, sub, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.valueOf(sudoku[i][j]));
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }
}
