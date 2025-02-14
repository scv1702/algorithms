package AcmicpcNet.Gold.N1715;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long ans = 0;
        if (N > 1) {
            while (pq.size() >= 2) {
                long x = pq.poll();
                long y = pq.poll();
                ans += x + y;
                pq.offer(x + y);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
