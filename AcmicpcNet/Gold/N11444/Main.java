package AcmicpcNet.Gold.N11444;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final long[][] IDENTITY = { { 1, 0 }, { 0, 1 } };

    private static long[][] pow(long[][] matrix, long k) {
        if (k == 0) return IDENTITY;
        if (k == 1) return mul(matrix, IDENTITY);
        long[][] half = pow(matrix, k / 2);
        if (k % 2 == 0) return mul(half, half);
        return mul(matrix, mul(half, half));
    }

    private static long[][] mul(long[][] A, long[][] B) {
        int N = A.length;
        long[][] res = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] = (res[i][j] % MOD + ((A[i][k] % MOD) * (B[k][j] % MOD)) % MOD) % MOD;
                }
            }
        }
        return res;
    }

    private static int fibo(long num) {
        if (num <= 1) return ((int) num) % MOD;
        long[][] matrix = { { 1, 1 }, { 1, 0 } };
        return (int) pow(matrix, num)[0][1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        String ans = String.valueOf(fibo(N));

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
