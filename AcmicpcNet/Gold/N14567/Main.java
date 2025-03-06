package AcmicpcNet.Gold.N14567;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static int[] mem;

    private static int solve(int[][] P, int B) {
        int N = P.length;
        if (mem[B] > 0) {
            return mem[B];
        }
        int res = 0;
        for (int A = 0; A < N; A++) {
            if (P[B][A] > 0) {
                res = Math.max(res, solve(P, A));
            }
        }
        return mem[B] = res + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[][] P = new int[N][N];
        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int A = line[0] - 1;
            int B = line[1] - 1;
            P[B][A] = 1;
        }

        mem = new int[N];

        String answer = IntStream.range(0, N)
                .map(B -> solve(P, B))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}

