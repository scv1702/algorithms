package AcmicpcNet.Gold.N2533;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int[][] mem;

    private static int solve(
        List<List<Integer>> tree,
        boolean[] visited,
        int root,
        int isRootEarlyAdopter
    ) {
        if (mem[root][isRootEarlyAdopter] >= 0) {
            return mem[root][isRootEarlyAdopter];
        }

        visited[root] = true;

        if (isRootEarlyAdopter == 1) {
            int countWhenRootIsEarlyAdopter = 1;
            for (int friend : tree.get(root)) {
                if (visited[friend]) continue;
                countWhenRootIsEarlyAdopter += Math.min(
                    solve(tree, visited, friend, 1),
                    solve(tree, visited, friend, 0)
                );
            }
            visited[root] = false;
            return mem[root][isRootEarlyAdopter] = countWhenRootIsEarlyAdopter;
        }

        int countWhenRootIsNotEarlyAdopter = 0;
        for (int friend : tree.get(root)) {
            if (visited[friend]) continue;
            int subCount = solve(tree, visited, friend, 1);
            countWhenRootIsNotEarlyAdopter += subCount;
        }
        visited[root] = false;
        return mem[root][isRootEarlyAdopter] = countWhenRootIsNotEarlyAdopter;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of());
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0];
            int v = line[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        mem = new int[1+N][2];
        for (int i = 0; i < 1+N; i++) {
            Arrays.fill(mem[i], -1);
        }

        boolean[] visited = new boolean[1+N];
        int answer = Math.min(
            solve(graph, visited, 1, 1),
            solve(graph, visited, 1, 0)
        );

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
