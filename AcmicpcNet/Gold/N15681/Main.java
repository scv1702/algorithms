package AcmicpcNet.Gold.N15681;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int dfs(List<List<Integer>> tree, int[] subtrees, boolean[] visited, int u) {
        subtrees[u] = 1;
        visited[u] = true;
        for (int v : tree.get(u)) {
            if (!visited[v]) {
                subtrees[u] += dfs(tree, subtrees, visited, v);
            }
        }
        return subtrees[u];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int R = line[1]; // 트리의 루트
        int Q = line[2];

        int[] subtrees = new int[1+N];
        boolean[] visited = new boolean[1+N];
        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int U = line[0];
            int V = line[1];
            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        dfs(tree, subtrees, visited, R);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(subtrees[U]) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
