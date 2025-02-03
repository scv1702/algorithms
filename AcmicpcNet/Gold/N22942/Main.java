package AcmicpcNet.Gold.N22942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[][] mem; // mem[시작][방문]
    private static final int INF = 16_000_001;

    private static boolean isVisited(int visited, int node) {
        return (visited & (1 << node)) > 0;
    }

    private static int solve(int[][] W, int start, int visited) {
        int N = W.length;

        if (visited == (1 << N) - 1) {
            if (W[start][0] > 0) {
                return W[start][0];
            }
            return INF;
        }

        if (mem[start][visited] != -1) {
            return mem[start][visited];
        }

        int min = INF;
        for (int next = 0; next < N; next++) {
            if (W[start][next] == 0) continue;
            if (isVisited(visited, next)) continue;
            int dis = W[start][next] + solve(W, next, visited | (1 << next));
            min = Math.min(min, dis);
        }

        return mem[start][visited] = min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][N];
        for (int i = 0; i < N; i++) {
            W[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        mem = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mem[i], -1);
        }

        int ans = solve(W, 0, 1);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
