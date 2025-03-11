package AcmicpcNet.Gold.N14728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int solve(int[][] mem, int[][] S, int depth, int T) {
        int N = S.length;

        if (depth >= N) {
            return 0;
        }

        int res = solve(mem, S, depth+1, T);
        if (T >= S[depth][0]) {
            res = Math.max(
                res,
                S[depth][1] + solve(mem, S, depth + 1, T - S[depth][0])
            );
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int T = line[1];

        int[][] S = new int[N][2];
        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int[] mem = new int[1+T];
        for (int i = 1; i <= N; i++) {
            int k = S[i-1][0]; // 예상 공부 시간
            int s = S[i-1][1]; // 배점
            for (int j = T; j >= k; j--) { // 가능한 공부 시간
                mem[j] = Math.max(
                    mem[j],
                    Math.max(
                        mem[j-k] + s,
                        mem[j]
                    )
                );
            }
        }

        int answer = mem[T];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
