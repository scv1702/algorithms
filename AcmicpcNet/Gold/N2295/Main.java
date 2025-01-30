package AcmicpcNet.Gold.N2295;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] U = new long[N];
        for (int i = 0; i < N; i++) {
            U[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(U);

        Set<Long> sum = new HashSet<>();
        Set<Long> diff = new HashSet<>();
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum.add(U[i] + U[j]);
                diff.add(U[j] - U[i]);
                map.put(U[j] - U[i], Math.max(
                    U[j], map.getOrDefault(
                        U[j] - U[i],
                        0L
                    )
                ));
            }
        }

        long ans = Long.MIN_VALUE;
        for (long d : sum) {
            if (diff.contains(d)) {
                ans = Math.max(ans, map.get(d));
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
