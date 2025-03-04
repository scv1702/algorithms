package AcmicpcNet.Gold.N13398;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static boolean[][] valid;
    private static int[][] mem;

    private static int solve(int[] A, int i, int jumped) {
        int N = A.length;

        if (i >= N) {
            return Integer.MIN_VALUE;
        }

        if (valid[i][jumped]) {
            return mem[i][jumped];
        }

        int max = solve(A, i+1, jumped);
        if (jumped == 0) {
            max = Math.max(max, solve(A, i+2, 1));
        }

        valid[i][jumped] = true;
        return mem[i][jumped] = A[i] + Math.max(0, max);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        valid = new boolean[N][2];
        mem = new int[N][2];
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, solve(A, i, 0));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
