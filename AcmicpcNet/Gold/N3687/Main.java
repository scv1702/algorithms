package AcmicpcNet.Gold.N3687;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] counts;
    private static int[][] mem;
    private static StringBuilder sb;

    private static int possible(int n, int k) {
        if (n < 0 || k < 0) return 0;
        if (mem[n][k] >= 0) return mem[n][k];
        if (k == 0) {
            if (n == 0) return mem[n][k] = 1;
            return mem[n][k] = 0;
        }
        if (k == 1) {
            if (n >= 2 && n <= 7) return mem[n][k] = 1;
            else return mem[n][k] = 0;
        }
        return mem[n][k] = possible(n - 2, k - 1) |
            possible(n - 3, k - 1) |
            possible(n - 4, k - 1) |
            possible(n - 5, k - 1) |
            possible(n - 6, k - 1) |
            possible(n - 7, k - 1);
    }

    private static void min(int n, int k, boolean first) {
        if (k <= 0) return ;
        for (int i = 0; i < 10; i++) {
            if (possible(n - counts[i][1], k - 1) > 0) {
                if (!first || counts[i][0] > 0) {
                    sb.append(counts[i][0]);
                    min(n - counts[i][1], k - 1, false);
                    return ;
                }
            }
        }
    }

    private static String max(int n) {
        StringBuilder sb = new StringBuilder();
        int result = 1;
        int r = n / 2 - 1;
        if (n % 2 != 0) {
            result = 7;
        }
        sb.append(result);
        sb.append("1".repeat(Math.max(0, r)));
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        counts = new int[][] {
            {0, 6}, {1, 2}, {2, 5}, {3, 5}, {4, 4}, {5, 5}, {6, 6}, {7, 3}, {8, 7}, {9, 6}
        };
        mem = new int[101][16];

        for (int i = 0; i < 101; i++) {
            Arrays.fill(mem[i], -1);
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int k = (n - 1) / 7 + 1;
            min(n, k, true);
            String min = sb.toString();
            sb.setLength(0);
            String max = max(n);
            bw.write(String.format("%s %s\n", min, max));
            bw.flush();
        }

        bw.flush();
        bw.close();
    }
}
