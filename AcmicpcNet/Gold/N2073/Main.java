package AcmicpcNet.Gold.N2073;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] mem;

    private static int solve(int[][] pipes, int D, int depth) {
        int P = pipes.length;

        if (depth >= P) {
            return -1;
        }

        if (mem[D][depth] >= -1) {
            return mem[D][depth];
        }

        int L = pipes[depth][0];
        int C = pipes[depth][1];

        int res = -1;

        if (D > L) {
            int with = solve(pipes, D - L, depth + 1);
            int without = solve(pipes, D, depth + 1);
            if (with > 0) {
                res = Math.max(res, Math.min(C, with));
            }
            if (without > 0) {
                res = Math.max(res, without);
            }
        } else if (D == L) {
            res = C;
        } else {
            int without = solve(pipes, D, depth + 1);
            if (without > 0) {
                res = without;
            }
        }

        return mem[D][depth] = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int D = line[0];
        int P = line[1];

        int[][] pipes = new int[P][2];
        for (int i = 0; i < P; i++) {
            pipes[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        mem = new int[1+D][P];
        for (int i = 0; i < 1+D; i++) {
            Arrays.fill(mem[i], -2);
        }

        Arrays.sort(pipes, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int answer = solve(pipes, D, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
