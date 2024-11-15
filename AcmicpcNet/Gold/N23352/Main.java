package AcmicpcNet.Gold.N23352;

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

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            System.arraycopy(nums, 0, arr[i], 0, M);
        }

        // 정답: 경로 (u, v)가 있을 때 최장 경로의 arr[ui][uj] + arr[vi][vj]
        // 정점 u에서 갈 수 있는 모든 v를 방문해보며 정답 계산
        int ans = 0;
        int md = 0; // 전체 경로 중 가장 긴 경로의 길이
        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        for (int u = 0; u < N * M; u++) {
            int ui = u / M;
            int uj = u % M;

            if (arr[ui][uj] == 0) continue;

            boolean[][] visited = new boolean[N][M];
            int[][] dists = new int[N][M];
            Queue<Integer> queue = new ArrayDeque<>();

            visited[ui][uj] = true;
            dists[ui][uj] = 1;
            queue.offer(u);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                int vi = v / M;
                int vj = v % M;
                for (int[] dir : dirs) {
                    int ni = vi + dir[0];
                    int nj = vj + dir[1];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < M &&
                        arr[ni][nj] != 0 && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        dists[ni][nj] = dists[vi][vj] + 1;
                        queue.offer(ni * M + nj);
                    }
                }
            }

            int uvmd = 0;
            int uvp = 0;
            for (int vi = 0; vi < N; vi++) {
                for (int vj = 0; vj < M; vj++) {
                    if (dists[vi][vj] > uvmd) {
                        uvmd = dists[vi][vj];
                        uvp = arr[ui][uj] + arr[vi][vj];
                    } else if (dists[vi][vj] == uvmd) {
                        uvp = Math.max(uvp, arr[ui][uj] + arr[vi][vj]);
                    }
                }
            }

            if (uvmd == md) {
                ans = Math.max(ans, uvp);
            } else if (uvmd > md) {
                md = uvmd;
                ans = uvp;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
