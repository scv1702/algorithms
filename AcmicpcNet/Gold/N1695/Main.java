package AcmicpcNet.Gold.N1695;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] map;

    private static int price(int[] A, int le, int rs) {
        int ls = 0;
        int re = A.length - 1;

        if (ls > le) {
            if (rs <= re) {
                return re - rs + 1;
            }
            return 0;
        }

        if (rs > re) {
            return le - ls + 1;
        }

        if (map[le][rs] > 0) {
            return map[le][rs];
        }

        if (A[le] == A[rs]) {
            return map[le][rs] = price(A, le - 1, rs + 1);
        }

        return map[le][rs] = Math.min(
            price(A, le-1, rs) + 1,
            price(A, le, rs+1) + 1
        );
    }

    private static int solve(int[] A, int mid) {
        int N = A.length;
        if (N % 2 == 0) {
            return Math.min(
                price(A, mid, mid+1),
                price(A, mid-1, mid+1)
            );
        }
        return price(A, mid-1, mid+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        map = new int[N][N];
        int answer = 5000;
        for (int i = 0; i < N; i++) {
            answer = Math.min(answer, solve(A, i));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
