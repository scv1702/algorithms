package AcmicpcNet.Gold.N16946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    private static void union(int[] root, int[] rank, int[] size, int x, int y) {
        int rootX = find(root, x);
        int rootY = find(root, y);
        if (rootX == rootY) return ;
        if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            root[rootY] = rootX;
            size[rootX] += size[rootY];
            if (rank[rootX] == rank[rootY]) {
                rank[rootX] += 1;
            }
        }
    }

    private static int find(int[] root, int x) {
        if (root[x] == x) return x;
        return root[x] = find(root, root[x]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(
                br.readLine().chars().map(n -> n - '0').toArray(),
                0,
                arr[i],
                0,
                M
            );
        }

        int[] size = new int[N * M];
        int[] rank = new int[N * M];
        int[] root = new int[N * M];
        int K = N * M;
        for (int i = 0; i < K; i++) {
            root[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) continue;
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= N) continue;
                    if (nj < 0 || nj >= M) continue;
                    if (arr[ni][nj] == 1) continue;
                    union(root, rank, size, i * M + j, ni * M + nj);
                }
            }
        }

        int[][] res = new int[N][M];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni < 0 || ni >= N) continue;
                        if (nj < 0 || nj >= M) continue;
                        if (arr[ni][nj] == 1) continue;
                        set.add(find(root, ni * M + nj));
                    }
                    for (int x : set) {
                        sum += size[x];
                    }
                    res[i][j] = sum;
                }
                sb.append(res[i][j] % 10);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
