package AcmicpcNet.Gold.N2758;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static long[][] mem;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int N = line[0];
            int M = line[1];
            mem = new long[1+N][1+M];

            for (int i = 1; i <= M; i++) {
                mem[1][i] = 1;
            }

            for (int i = 2; i <= N; i++) { // i: 뽑은 숫자 개수
                for (int j = 1; j <= M; j++) { // j: 뽑은 숫자 중 마지막 수
                    for (int k = 1; k <= j/2; k++) {
                        mem[i][j] += mem[i-1][k];
                    }
                }
            }

            long answer = 0;
            for (int j = 1; j <= M; j++) {
                answer += mem[N][j];
            }

            bw.write(String.format("%d\n", answer));
        }

        bw.flush();
        bw.close();
    }
}
