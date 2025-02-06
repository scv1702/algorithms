package AcmicpcNet.Gold.N1025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static boolean isSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private static long ans = -1;

    private static long toNum(List<Integer> nums) {
        return Long.parseLong(
            nums.stream()
                .map(String::valueOf)
                .collect(Collectors.joining())
        );
    }

    private static void dfs(
        int[][] A,
        List<Integer> nums,
        int r,
        int c,
        int rd,
        int cd
    ) {
        int N = A.length;
        int M = A[0].length;

        nums.add(A[r][c]);

        int nr = r + rd;
        int nc = c + cd;

        long num = toNum(nums);
        if (isSquare(num)) {
            ans = Math.max(ans, num);
        }

        if (
            (nr < 0 || nr >= N || nc < 0 || nc >= M) ||
            (r == nr && c == nc)
        ) {
            return ;
        }

        dfs(A, nums, nr, nc, rd, cd);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().chars()
                .map(v -> v - '0')
                .toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int rd = -N; rd <= N; rd++) {
                    for (int cd = -M; cd <= M; cd++) {
                        List<Integer> nums = new ArrayList<>();
                        dfs(A, nums, i, j, rd, cd);
                    }
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
