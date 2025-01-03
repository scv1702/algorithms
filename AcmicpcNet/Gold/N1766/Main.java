package AcmicpcNet.Gold.N1766;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            graph.get(u).add(v);
            inDegree[v] += 1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            sb.append(u + 1).append(" ");
            for (int v : graph.get(u)) {
                inDegree[v] -= 1;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
