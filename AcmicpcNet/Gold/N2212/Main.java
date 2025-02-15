package AcmicpcNet.Gold.N2212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        int K = Integer.parseInt(br.readLine());
        int[] S = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .distinct()
            .toArray();
        int N = S.length;

        Arrays.sort(S);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s[1] - s[0]));
        for (int i = 1; i < N; i++) {
            pq.offer(new int[] { S[i-1], S[i] });
        }

        long ans = 0;
        int count = N;
        while (!pq.isEmpty() && count > K) {
            int[] range = pq.poll();
            int start = range[0];
            int end = range[1];
            count -= 1;
            ans += (end - start);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
