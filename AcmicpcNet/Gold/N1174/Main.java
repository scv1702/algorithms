package AcmicpcNet.Gold.N1174;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static int count = 0;
    private static long answer = -1;

    private static boolean isDescending(long n) {
        long d = n % 10;
        long r = n / 10;
        while (r > 0) {
            long nd = r % 10;
            if (nd <= d) return false;
            d = nd;
            r = r / 10;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Long> queue = new ArrayDeque<>();
        for (long i = 0; i < 10; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            long i = queue.poll();
            if (isDescending(i)) {
                count += 1;
            }
            if (count == N) {
                answer = i;
                break;
            }
            long d = i % 10;
            for (int j = 0; j < d; j++) {
                long next = Long.parseLong(String.format("%d%d", i, j));
                queue.offer(next);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
