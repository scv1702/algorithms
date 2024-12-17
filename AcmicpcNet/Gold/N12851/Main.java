package AcmicpcNet.Gold.N12851;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    private static final int MAX = 200_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int K = line[1];

        Queue<int[]> queue = new ArrayDeque<>();
        int[] visited = new int[1+MAX]; // 방문한 시간
        int[] count = new int[1+MAX];

        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[N] = 0;
        count[N] = 1;
        queue.offer(new int[] { N, 0 });

        while (!queue.isEmpty()) { // 특정 정점을 중복에서 방문할 수 있지만, 방문 시간이 같아야 한다.
            int[] tuple = queue.poll();
            int node = tuple[0];
            int time = tuple[1];
            int[] nexts = { node - 1, node + 1, 2 * node };
            for (int next : nexts) {
                if (next < 0 || next > MAX) continue;
                if (time + 1 > visited[K]) continue;
                if (visited[next] == Integer.MAX_VALUE) {
                    count[next] += count[node];
                    visited[next] = time + 1;
                    queue.offer(new int[] { next, time + 1 });
                } else if (visited[next] == time + 1) {
                    count[next] += count[node];
                }
            }
        }

        String ans = String.format("%d\n%d", visited[K], count[K]);
        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
