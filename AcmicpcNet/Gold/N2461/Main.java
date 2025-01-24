package AcmicpcNet.Gold.N2461;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int M = line[1];
        int[][] S = new int[N][M];
        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            Arrays.sort(S[i]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n[2]));
        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, S[i][0]);
            pq.offer(new int[] { i, 0, S[i][0] });
        }

        while (true) {
            int[] curr = pq.poll();
            int minClass = curr[0];
            int minIndex = curr[1];
            int min = curr[2];
            ans = Math.min(ans, max - min);
            int next = minIndex + 1;
            if (next == M) break;
            max = Math.max(max, S[minClass][next]);
            pq.offer(new int[] { minClass, next, S[minClass][next] });
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
