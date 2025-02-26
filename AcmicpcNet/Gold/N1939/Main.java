package AcmicpcNet.Gold.N1939;

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

        List<Map<Integer, Integer>> map = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map.add(new HashMap<>());
        }

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int u = line[0] - 1;
            int v = line[1] - 1;
            int w = line[2];
            map.get(u).put(v, Math.max(map.get(u).getOrDefault(v, 0), w));
            map.get(v).put(u, Math.max(map.get(v).getOrDefault(u, 0), w));
        }

        line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int A = line[0] - 1;
        int B = line[1] - 1;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(q -> -q[1]));
        int[] visited = new int[N];
        visited[A] = Integer.MAX_VALUE;
        queue.offer(new int[] { A, Integer.MAX_VALUE });

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int w = curr[1];

            if (u == B) {
                answer = w;
                break;
            }

            Map<Integer, Integer> next = map.get(u);
            next.forEach((k, v) -> {
                int nw = Math.min(w, v);
                if (nw > visited[k]) {
                    visited[k] = nw;
                    queue.offer(new int[] { k, nw });
                }
            });
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

