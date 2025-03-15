package AcmicpcNet.Gold.N1106;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BottomUp {

    private static final int INF = 100_001;
    private static int[][] mem;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int C = line[0];
        int N = line[1];

        int[][] P = new int[N][2];
        for (int i = 0; i < N; i++) {
            P[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        mem = new int[1+N][1+C];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(mem[i], INF);
            mem[i][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            int price = P[i-1][0];
            int customer = P[i-1][1];
            for (int j = 0; j <= C; j++) {
                mem[i][j] = mem[i-1][j];
                for (int k = 0; customer * k <= j + customer; k++) {
                    if (j > customer * k) {
                        mem[i][j] = Math.min(mem[i][j], price * k + mem[i-1][j - customer * k]);
                    } else {
                        mem[i][j] = Math.min(mem[i][j], price * k);
                    }
                }
            }
        }

        int answer = mem[N][C];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
