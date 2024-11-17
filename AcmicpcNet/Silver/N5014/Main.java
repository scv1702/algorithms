package AcmicpcNet.Silver.N5014;

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

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int F = line[0]; // 건물 높이
        int S = line[1]; // 현재 층
        int G = line[2]; // 도착 층
        int U = line[3]; // 올라갈 수 있는 층 수
        int D = line[4]; // 내려갈 수 있는 층 수

        int ans = -1;

        int[] buttons = { U, -D };
        boolean[] visited = new boolean[F+1];
        Queue<int[]> queue = new ArrayDeque<>();

        visited[S] = true;
        queue.offer(new int[] {S, 0});

        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int floor = tuple[0];
            int cnt = tuple[1];
            if (floor == G) {
                ans = cnt;
                break;
            }
            for (int button : buttons) {
                int next = floor + button;
                if (next < 1 || next > F) continue;
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(new int[] {next, cnt + 1});
            }
        }
        if (ans >= 0) {
            bw.write(String.valueOf(ans) + '\n');
        } else {
            bw.write("use the stairs\n");
        }

        bw.flush();
        bw.close();
    }
}
