package AcmicpcNet.Gold.N18427;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int MOD= 10_007;
    private static int[][] mem;

    private static int solve(int[][] S, int H, int depth) {
        int N = S.length;
        int M = S[0].length;

        if (H < 0) {
            return 0;
        }

        if (H == 0) {
            return 1;
        }

        if (depth >= N) {
            return 0;
        }

        if (mem[H][depth] >= 0) return mem[H][depth];

        int res = solve(S, H, depth+1);
        for (int i = 0; i < M; i++) {
            if (S[depth][i] <= 0) break;
            res = (res + solve(S, H-S[depth][i], depth+1)) % MOD;
        }

        return mem[H][depth] = res % MOD;
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

        int[][] S = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
            System.arraycopy(
                line,
                0,
                S[i],
                0,
                line.length
            );
        }

        mem = new int[1+H][N];
        for (int i = 0; i < 1+H; i++) {
            Arrays.fill(mem[i], -1);
        }

        int answer = solve(S, H, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
