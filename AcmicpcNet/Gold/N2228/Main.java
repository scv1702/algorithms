package AcmicpcNet.Gold.N2228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int max(int... arr) {
        return Arrays.stream(arr)
            .max()
            .orElse(0);
    }

    private static boolean[][] valid;
    private static int[][] mem;

    // i: 탐색 시작 지점
    private static int solve(int[] S, int M, int i) {
        int N = S.length;

        if (i >= N) {
            return Integer.MIN_VALUE;
        }

        if (valid[M][i]) {
            return mem[M][i];
        }

        int res = Integer.MIN_VALUE;
        if (M == 1) {
            // j: 구간 시작 지점
            for (int j = i; j < N; j++) {
                // k: 구간 종료 지점
                for (int k = j; k < N; k++) {
                    res = max(
                        res,
                        S[k] - S[j-1]
                    );
                }
            }
        } else {
            // j: 구간 시작 지점
            for (int j = i; j < N; j++) {
                // k: 구간 종료 지점
                for (int k = j; k < N; k++) {
                    int temp = solve(S, M-1, k+2);
                    if (temp != Integer.MIN_VALUE) {
                        res = max(
                            res,
                            S[k] - S[j-1] + temp
                        );
                    }
                }
            }
        }

        valid[M][i] = true;
        return mem[M][i] = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int[] S = new int[1+N];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + A[i-1];
        }

        mem = new int[1+M][2+N];
        valid = new boolean[1+M][2+N];

        int answer = solve(S, M, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
