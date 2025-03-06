package AcmicpcNet.Gold.N21757;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] S = new int[1+N];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + A[i-1];
        }

        long answer = 0;
        if (S[N] == 0) {
            long zero = 0;
            for (int i = 1; i <= N; i++) {
                if (S[i] == 0) {
                    zero += 1;
                }
            }
            if (zero >= 3) {
                answer = ((zero - 1) * (zero - 2) * (zero - 3)) / 6;
            }
        } else if (S[N] % 4 == 0) {
            long[] G = new long[4];
            G[0] = 1;
            int s = S[N] / 4;
            for (int i = 1; i <= N; i++) {
                if (S[i] == s) {
                    G[1] += G[0];
                }
                if (S[i] == 2 * s) {
                    G[2] += G[1];
                }
                if (S[i] == 3 * s) {
                    G[3] += G[2];
                }
            }
            answer = G[3];
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
