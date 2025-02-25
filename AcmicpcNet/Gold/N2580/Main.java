package AcmicpcNet.Gold.N2580;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static boolean possible(int[][] map, int k, int depth) {
        int i = depth / 9;
        int j = depth % 9;

        for (int r = 0; r < 9; r++) {
            if (map[r][j] == k) return false;
        }
        for (int c = 0; c < 9; c++) {
            if (map[i][c] == k) return false;
        }
        for (int r = 3 * (i / 3); r < 3 * (i / 3) + 3; r++) {
            for (int c = 3 * (j / 3); c < 3 * (j / 3) + 3; c++) {
                if (map[r][c] == k) return false;
            }
        }

        return true;
    }

    private static boolean solve(int[][] map, int depth) {
        int i = depth / 9;
        int j = depth % 9;

        if (i >= 9) return true;

        if (map[i][j] > 0) {
            return solve(map, depth + 1);
        }

        for (int k = 1; k <= 9; k++) {
            if (possible(map, k, depth)) {
                map[i][j] = k;
                if (solve(map, depth + 1)) {
                    return true;
                }
                map[i][j] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        solve(map, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
