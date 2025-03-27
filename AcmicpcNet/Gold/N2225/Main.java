package AcmicpcNet.Gold.N2225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int K = line[1];

        int[][] map = new int[1+N][1+K];
        for (int i = 1; i <= K; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) { // 만들 수
            map[i][1] = 1;
            for (int j = 2; j <= K; j++) { // 사용할 개수
                for (int k = 0; k <= i; k++) {
                    map[i][j] = (map[i][j] + map[i-k][j-1]) % MOD;
                }
            }
        }

        int answer = map[N][K];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
