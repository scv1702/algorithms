package AcmicpcNet.Gold.N6593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    // 동, 서, 남, 북, 상, 하
    private static final int[][] dirs = {
        {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int L = line[0];
            int R = line[1];
            int C = line[2];

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            char[][][] building = new char[L][R][C];
            int[] start = new int[3];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                            building[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }

            int ans = -1;
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][][] visited = new boolean[L][R][C];

            int si = start[0];
            int sj = start[1];
            int sk = start[2];
            visited[si][sj][sk] = true;
            queue.offer(new int[] { si, sj ,sk, 0 });

            while (!queue.isEmpty()) {
                int[] u = queue.poll();
                int ui = u[0];
                int uj = u[1];
                int uk = u[2];
                int t = u[3];
                if (building[ui][uj][uk] == 'E') {
                    ans = t;
                    break;
                }
                for (int[] dir : dirs) {
                    int vi = ui + dir[0];
                    int vj = uj + dir[1];
                    int vk = uk + dir[2];
                    if (vi < 0 || vi >= L) continue;
                    if (vj < 0 || vj >= R) continue;
                    if (vk < 0 || vk >= C) continue;
                    if (building[vi][vj][vk] == '#') continue;
                    if (visited[vi][vj][vk]) continue;
                    visited[vi][vj][vk] = true;
                    queue.offer(new int[] { vi, vj, vk, t + 1 });
                }
            }

            if (ans >= 0) {
                bw.write(String.format("Escaped in %d minute(s).\n", ans));
            } else {
                bw.write("Trapped!\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
