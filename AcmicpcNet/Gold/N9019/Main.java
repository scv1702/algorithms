package AcmicpcNet.Gold.N9019;

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

        int MAX = 10000;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int A = line[0];
            int B = line[1];

            int[] prev = new int[MAX];
            char[] op = new char[MAX];
            boolean[] visited = new boolean[MAX];
            Queue<Integer> queue = new ArrayDeque<>();

            visited[A] = true;
            prev[A] = A;
            queue.offer(A);

            while (!queue.isEmpty()) {
                int num = queue.poll();

                if (num == B) {
                    break;
                }

                int D = (2 * num) % MAX;
                if (!visited[D]) {
                    visited[D] = true;
                    op[D] = 'D';
                    prev[D] = num;
                    queue.offer(D);
                }

                int S = (num - 1 + MAX) % MAX;
                if (!visited[S]) {
                    visited[S] = true;
                    op[S] = 'S';
                    prev[S] = num;
                    queue.offer(S);
                }

                int L = (num % 1000) * 10 + (num / 1000);
                if (!visited[L]) {
                    visited[L] = true;
                    op[L] = 'L';
                    prev[L] = num;
                    queue.offer(L);
                }

                int R = (num % 10) * 1000 + (num / 10);
                if (!visited[R]) {
                    visited[R] = true;
                    op[R] = 'R';
                    prev[R] = num;
                    queue.offer(R);
                }
            }

            StringBuilder sb = new StringBuilder();

            int i = B;
            while (i != A) {
                sb.append(op[i]);
                i = prev[i];
            }
            sb.reverse();

            bw.write(sb.toString() + '\n');
        }

        bw.flush();
        bw.close();
    }
}
