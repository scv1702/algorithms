package AcmicpcNet.Gold.N25547;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Integer> decompose(int n) {
        if (n == 1) {
            return Map.of();
        }
        Map<Integer, Integer> result = new HashMap();
        double sqrt = Math.sqrt(n);
        boolean isPrime = true;
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                result.put(i, result.getOrDefault(i, 0) + 1);
                Map<Integer, Integer> map = decompose(n / i);
                map.forEach((k, v) -> {
                    result.put(k, result.getOrDefault(k, 0) + v);
                });
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            return Map.of(n, 1);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
        int a = line[0];
        int b = line[1];

        int ans = 1;

        if (b % a != 0) {
            ans = 0;
        } else {
            Map<Integer, Integer> map = decompose(b / a);
            for (int k : map.keySet()) {
                int v = map.get(k);
                ans = ans * (v + 1);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
