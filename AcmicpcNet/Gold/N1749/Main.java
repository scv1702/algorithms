package AcmicpcNet.Gold.N1749;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int[][] sum = new int[1+N][1+M];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + map[i-1][j-1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int a = 1; a <= N; a++) {
            for (int c = a; c <= N; c++) {
                for (int b = 1; b <= M; b++) {
                    for (int d = b; d <= M; d++) {
                        answer = Math.max(answer, sum[c][d] - sum[c][b-1] - sum[a-1][d] + sum[a-1][b-1]);
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
