package AcmicpcNet.Gold.N2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[] inDegree = new int[N];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int A = line[0] - 1;
            int B = line[1] - 1;
            graph.get(A).add(B);
            inDegree[B] += 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            int u = queue.poll();
            ans[i] = u + 1;
            for (int v : graph.get(u)) {
                inDegree[v] -= 1;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        bw.write(Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
        bw.flush();
        bw.close();
    }
}
