package AcmicpcNet.Gold.N22862;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int K = line[1];
        int[] S = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        List<Integer> counts = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (S[i] % 2 == 0) {
                count += 1;
            } else {
                counts.add(count);
            }
        }
        counts.add(count);

        int ans = 0;
        int oddCount = counts.size() - 1;

        if (oddCount == 0) {
            ans = N;
        } else if (oddCount <= K) {
            ans = N - oddCount;
        } else {
            int i = 0;
            while (i + K + 1 < counts.size()) {
                int len = counts.get(i + K + 1) - counts.get(i);
                ans = Math.max(ans, len);
                i += 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}