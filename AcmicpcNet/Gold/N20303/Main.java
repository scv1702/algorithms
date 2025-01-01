package AcmicpcNet.Gold.N20303;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static int find(int[] root, int x) {
        if (root[x] == x) return x;
        return root[x] = find(root, root[x]);
    }

    private static void union(int[] rank, int[] root, int x, int y) {
        int rootX = find(root, x);
        int rootY = find(root, y);

        if (rootX == rootY) return ;

        if (rank[rootX] < root[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            if (rank[rootX] == rank[rootY]) {
                rank[rootX] += 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0]; // 아이 수
        int M = line[1]; // 관계 수
        int K = line[2]; // 공명 조건

        int[] C = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] edge = new int[M][2];
        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = line[0] - 1;
            int b = line[1] - 1;
            edge[i][0] = a;
            edge[i][1] = b;
        }

        int[] root = new int[N];
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            union(rank, root, a, b);
        }

        for (int i = 0; i < N; i++) {
            find(root, i);
        }

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int r = root[i];
            if (!map.containsKey(r)) {
                map.put(r, new int[] { 1, C[i] });
            } else {
                int[] prev = map.get(r);
                map.put(r, new int[] { prev[0] + 1, prev[1] + C[i] });
            }
        }

        int[][] sum = map.values().toArray(new int[0][]);
        int S = sum.length;
        int[][] dp = new int[K][S];

        for (int i = 1; i < K; i++) {
            if (sum[0][0] <= i) {
                dp[i][0] = sum[0][1];
            }
        }

        for (int i = 1; i < K; i++) {
            for (int j = 1; j < S; j++) {
                if (sum[j][0] > i) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i-sum[j][0]][j-1] + sum[j][1],
                        dp[i][j-1]
                    );
                }
            }
        }

        bw.write(String.valueOf(dp[K-1][S-1]));
        bw.flush();
        bw.close();
    }
}
