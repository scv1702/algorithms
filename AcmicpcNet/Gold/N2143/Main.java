package AcmicpcNet.Gold.N2143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int m = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sumOfA = new int[1+n];
        int[] sumOfB = new int[1+m];

        for (int i = 1; i <= n; i++) {
            sumOfA[i] = sumOfA[i-1] + A[i-1];
        }

        for (int i = 1; i <= m; i++) {
            sumOfB[i] = sumOfB[i-1] + B[i-1];
        }

        Map<Integer, Integer> countOfA = new HashMap<>();
        Map<Integer, Integer> countOfB = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = sumOfA[j] - sumOfA[i-1];
                countOfA.put(sum, countOfA.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int sum = sumOfB[j] - sumOfB[i-1];
                countOfB.put(sum, countOfB.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0;

        for (int sumA : countOfA.keySet()) {
            int countA = countOfA.get(sumA);
            int sumB = T - sumA;
            int countB = countOfB.get(sumB);
            if (countOfB.containsKey(sumB)) {
                answer += ((long) countA) * countB;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
