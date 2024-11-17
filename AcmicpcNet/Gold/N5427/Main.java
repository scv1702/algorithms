package AcmicpcNet.Gold.N5427;

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

        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int C = line[0];
            int R = line[1];

            char[][] maze = new char[R][C]; // 미로
            int si = 0;  // 지훈 시작 행
            int sj = 0;  // 지훈 시작 열

            // 지훈 시작 위치 탐색
            for (int i = 0; i < R; i++) {
                String ml = br.readLine();
                for (int j = 0; j < C; j++) {
                    char c = ml.charAt(j);
                    if (c == '@') {
                        si = i;
                        sj = j;
                        c = '.';
                    }
                    maze[i][j] = c;
                }
            }

            int[][] dirs = {
                    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
            };
            int[][] fired = new int[R][C]; // 불이 난 시간을 저장
            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < R; i++) {
                // 초기값을 무한대로 저장
                // -1로 초기화하는 경우, 지훈이가 불이 난 곳인지 판단하는 식인 (fired[vi][vj] <= t + 1)에서
                // 불이 나지 않았음에도 불이 났다고 판단하게 되버림
                Arrays.fill(fired[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (maze[i][j] == '*') {
                        fired[i][j] = 0;
                        queue.offer(new int[] { i * C + j, 0 });
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int u = tuple[0];
                int ui = u / C;
                int uj = u % C;
                int t = tuple[1];
                for (int[] dir : dirs) {
                    int vi = ui + dir[0];
                    int vj = uj + dir[1];
                    if (vi < 0 || vi >= R || vj < 0 || vj >= C) continue;
                    if (maze[vi][vj] != '.') continue;
                    if (t + 1 < fired[vi][vj]) {
                        fired[vi][vj] = t + 1;
                        queue.offer(new int[] { vi * C + vj, t + 1 });
                    }
                }
            }

            int ans = -1;
            boolean[][] visited = new boolean[R][C];

            visited[si][sj] = true;
            queue.offer(new int[] { si * C + sj, 0 });

            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int u = tuple[0];
                int ui = u / C;
                int uj = u % C;
                int t = tuple[1];
                if (ui == 0 || ui == R-1 || uj == 0 || uj == C-1) {
                    ans = t + 1;
                    break;
                }
                for (int[] dir : dirs) {
                    int vi = ui + dir[0];
                    int vj = uj + dir[1];
                    if (vi < 0 || vi >= R || vj < 0 || vj >= C) continue;
                    if (visited[vi][vj]) continue;
                    if (fired[vi][vj] <= t + 1) continue;
                    if (maze[vi][vj] != '.') continue;
                    visited[vi][vj] = true;
                    queue.offer(new int[] { vi * C + vj, t + 1 });
                }
            }

            if (ans >= 0) {
                bw.write(String.valueOf(ans) + '\n');
            } else {
                bw.write("IMPOSSIBLE\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
