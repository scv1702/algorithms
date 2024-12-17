package AcmicpcNet.Gold.N10830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int MOD = 1000;
    private static int[][] identity;

    private static int[][] pow(int[][] A, long k) {
        if (k == 0) {
            return identity;
        } else if (k == 1) {
            return mut(A, identity);
        }

        int[][] half = pow(A, k/2);

        return (k % 2 == 0) ? mut(half, half): mut(mut(half, half), A);
    }

    private static int[][] mut(int[][] A, int[][] B) {
        int N = A.length;
        int[][] res = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int k = 0; k < N; k++) {
                    res[r][c] += (A[r][k] * B[k][c]) % MOD;
                }
                res[r][c] %= MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] line = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        int N = (int) line[0];
        long B = line[1];

        int[][] A = new int[N][N];
        identity = new int[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                0,
                A[i],
                0,
                N
            );
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    identity[i][j] = 1;
                }
            }
        }

        int[][] res = pow(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(' ');
            }
            sb.append('\n');
        }

        String ans = sb.toString();
        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
