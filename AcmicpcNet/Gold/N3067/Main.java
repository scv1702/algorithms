package AcmicpcNet.Gold.N3067;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] C = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int M = Integer.parseInt(br.readLine());

            int[] mem = new int[1+M];
            mem[0] = 1;

            for (int i = 0; i < N; i++) {
                int coin = C[i];
                for (int j = coin; j <= M; j++) {
                    mem[j] += mem[j-coin];
                }
            }

            int res = mem[M];

            bw.write(String.format("%d\n", res));
        }

        bw.flush();
        bw.close();
    }
}
