package AcmicpcNet.Gold.N1106;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class TopDown {

    private static final int INF = 100_001;
    private static int[][] mem;

    private static int solve(
        int[][] P,
        int left,
        int depth
    ) {
        int N = P.length;

        if (left <= 0) {
            return 0;
        }

        if (depth >= N) {
            return INF;
        }

        if (mem[left][depth] > 0) {
            return mem[left][depth];
        }

        int price = P[depth][0];
        int customer = P[depth][1];

        int res = INF;
        for (int i = 0; customer * i <= left + customer; i++) {
            res = Math.min(res, price * i + solve(P, left - customer * i, depth + 1));
        }

        return mem[left][depth] = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int C = line[0];
        int N = line[1];

        int[][] P = new int[N][2];
        for (int i = 0; i < N; i++) {
            P[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        mem = new int[1+C][N];
        int answer = solve(P, C, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
