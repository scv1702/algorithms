package AcmicpcNet.Gold.N2141;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] P = new int[N][2];
        for (int i = 0; i < N; i++) {
            P[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        Arrays.sort(P, Comparator.comparingInt(p -> p[0]));

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i][1];
        }

        long mid = sum / 2;
        if (sum % 2 != 0) {
            mid += 1;
        }

        int ans = 0;
        long prefix = 0;
        for (int i = 0; i < N; i++) {
            prefix += P[i][1];
            if (prefix >= mid) {
                ans = P[i][0];
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
