package AcmicpcNet.Gold.N2248;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static void paint(char[][] map, int row, int col) {
        map[row][col] = '*';

        map[row + 1][col - 1] = '*';
        map[row + 1][col + 1] = '*';

        map[row + 2][col - 2] = '*';
        map[row + 2][col - 1] = '*';
        map[row + 2][col] = '*';
        map[row + 2][col + 1] = '*';
        map[row + 2][col + 2] = '*';
    }

    private static void solve(char[][] map, int k, int row, int col) {
        int height = (int) (3 * Math.pow(2, k));
        int width = (int) (6 * Math.pow(2, k)) - 1;
        if (k == 0) {
            paint(map, row, col);
            return ;
        }
        solve(map, k-1, row, col);
        solve(map, k-1, row + height / 2, col - width / 4 - 1);
        solve(map, k-1, row + height / 2, col + width / 4 + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = (int) (Math.log(N / 3) / Math.log(2));
        int W = (int) (6 * Math.pow(2, K)) - 1;

        char[][] map = new char[N][W];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        solve(map, K, 0, W / 2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        String answer = sb.toString();
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
