package AcmicpcNet.Silver.N2583;

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
        int M = line[0];
        int N = line[1];
        int K = line[2];

        int[][] map = new int[M][N];
        for (int i = 0; i < K; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x0 = line[0];
            int y0 = line[1];
            int x1 = line[2];
            int y1 = line[3];

            for (int x = x0; x < x1; x++) {
                for (int y = y0; y < y1; y++) {
                    map[y][x] = 1;
                }
            }
        }

        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        boolean[][] visited = new boolean[M][N];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 1) continue;
                int area = 1;
                visited[i][j] = true;
                queue.offer(i * N + j);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    int ui = u / N;
                    int uj = u % N;
                    for (int[] dir : dirs) {
                        int vi = ui + dir[0];
                        int vj = uj + dir[1];
                        if (vi < 0 || vi >= M || vj < 0 || vj >= N) continue;
                        if (visited[vi][vj]) continue;
                        if (map[vi][vj] == 1) continue;
                        visited[vi][vj] = true;
                        area += 1;
                        queue.offer(vi * N + vj);
                    }
                }
                areas.add(area);
            }
        }

        String ans = areas.stream()
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));

        bw.write(String.valueOf(areas.size()) + '\n');
        bw.write(ans);

        bw.flush();
        bw.close();
    }
}
