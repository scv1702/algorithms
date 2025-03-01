package AcmicpcNet.Gold.N1823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] mem;

    private static int solve(int[] A, int left, int right, int depth) {
        if (left > right) {
            return 0;
        }

        if (mem[left][right] >= 0) {
            return mem[left][right];
        }

        return mem[left][right] = Math.max(
            A[right] * depth + solve(A, left, right-1, depth+1),
            A[left] * depth + solve(A, left+1, right, depth+1)
        );
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mem = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mem[i],- 1);
        }

        int answer = solve(A, 0, N-1, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
