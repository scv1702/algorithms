package AcmicpcNet.Gold.N2306;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] mem;

    private static int dfs(char[] arr, int start, int end) {
        if (mem[start][end] >= 0) return mem[start][end];
        if (start >= end) return mem[start][end] = 0;

        int res = 0;
        if ((arr[start] == 'a' && arr[end] == 't') ||
            (arr[start] == 'g' && arr[end] == 'c')) {
            res = dfs(arr, start + 1, end - 1) + 2;
        }

        for (int i = start; i < end; i++) {
            int X = dfs(arr, start, i);
            int Y = dfs(arr, i+1, end);
            res = Math.max(res, X + Y);
        }

        return mem[start][end] = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        int N = arr.length;
        mem = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mem[i], -1);
        }
        int ans = dfs(arr, 0, N-1);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
