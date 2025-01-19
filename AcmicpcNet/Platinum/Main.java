package AcmicpcNet.Platinum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int answer = 0;

    private static final int[][] dirs = {
        { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }
    };

    public static void dfs(int[][] arr, boolean[][] put, int node) {
        int N = arr.length;

        if (node == N*N) {
            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (put[i][j]) res += 1;
                }
            }
            answer = Math.max(answer, res);
            return ;
        }

        int next = 0;
        int now = 0;
        while (next < node) {
            int i = next / N;
            int j = next % N;
            if (put[i][j]) now += 1;
            next += 1;
        }

        next = node;
        int left = 0;
        while (next < N*N) {
            int i = next / N;
            int j = next % N;
            if (arr[i][j] == 1) left += 1;
            next += 1;
        }

        if (answer > now + left) {
            return ;
        }

        int i = node / N;
        int j = node % N;

        if (arr[i][j] == 0 || arr[i][j] >= 2) {
            dfs(arr, put, node + 1);
            return ;
        }

        put[i][j] = true;
        for (int[] dir : dirs) {
            int ni = i;
            int nj = j;
            while (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                if (arr[ni][nj] > 0) {
                    arr[ni][nj] += 1;
                }
                ni += dir[0];
                nj += dir[1];
            }
        }
        dfs(arr, put, node + 1);

        put[i][j] = false;
        for (int[] dir : dirs) {
            int ni = i;
            int nj = j;
            while (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                if (arr[ni][nj] > 0) {
                    arr[ni][nj] -= 1;
                }
                ni += dir[0];
                nj += dir[1];
            }
        }
        dfs(arr, put, node + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                0,
                arr[i],
                0,
                N
            );
        }

        boolean[][] visited = new boolean[N][N];
        dfs(arr, visited, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
