package AcmicpcNet.Gold.N2623;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[][] graph = new int[N][N];
        int[] inDegree = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 2; j < line.length; j++) {
                int u = line[j-1] - 1;
                int v = line[j] - 1;
                if (graph[u][v] == 0) {
                    graph[u][v] = 1;
                    inDegree[v] += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean failed = false;

        for (int i = 0; i < N; i++) {
            if (queue.isEmpty()) {
                failed = true;
                break;
            }
            int singer = queue.poll();
            sb.append(singer + 1).append('\n');
            for (int j = 0; j < N; j++) {
                if (graph[singer][j] == 1) {
                    inDegree[j] -= 1;
                    if (inDegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }

        String answer = failed ? "0\n" : sb.toString();

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
