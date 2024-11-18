package AcmicpcNet.Gold.N9466;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 그래프의 싸이클에 속하지 않는 정점 개수를 구하라.
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] edges = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s) - 1)
                .toArray();

            int teams = 0;
            int d = 1;
            int[] visited = new int[n];

            for (int s = 0; s < n; s++) {
                if (visited[s] > 0) { // 이미 방문한 정점의 경우, 이전에 검사 완료
                    continue;
                }

                Queue<Integer> queue = new ArrayDeque<>();

                visited[s] = d++;
                queue.offer(s);

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    int v = edges[u];
                    if (visited[v] > 0 && visited[v] < visited[s]) {
                        break;
                    }
                    if (visited[v] >= visited[s]) { // 싸이클 발생
                        teams += (visited[u] - visited[v] + 1);
                        break;
                    }
                    visited[v] = d++;
                    queue.offer(v);
                }
            }

            int ans = n - teams;

            bw.write(String.valueOf(ans) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
