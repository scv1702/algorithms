package AcmicpcNet.Gold.N16724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final int[][] dirs = {
        { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    private static void union(int[] root, int[] rank, int a, int b) {
        int rootA = find(root, a);
        int rootB = find(root, b);

        if (rootA == rootB) return;

        if (rank[a] < rank[b]) {
            root[rootA] = rootB;
        } else {
            root[rootB] = rootA;
            if (rank[a] == rank[b]) {
                rank[rootA] += 1;
            }
        }
    }

    private static int find(int[] root, int node) {
        if (root[node] == node) return node;
        return root[node] = find(root, root[node]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        char[][] opcodes = new char[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(br.readLine().toCharArray(), 0, opcodes[i], 0, M);
        }

        int[] root = new int[N*M];
        int[] rank = new int[N*M];

        for (int i = 0; i < N*M; i++) {
            root[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int dir = "UDLR".indexOf(opcodes[i][j]);
                int ni = i + dirs[dir][0];
                int nj = j + dirs[dir][1];
                union(root, rank, i * M + j, ni * M + nj);
            }
        }

        for (int i = 0; i < N*M; i++) {
            find(root, i);
        }

        Set<Integer> set = Arrays.stream(root).boxed().collect(Collectors.toSet());
        int answer = set.size();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
