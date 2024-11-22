package AcmicpcNet.Silver.N11660;

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

        int[][] arr = new int[1+N][1+N];
        int[][] sum = new int[1+N][1+N];

        for (int i = 1; i <= N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                arr[i],
                1,
                N
            );
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        for (int i = 1; i <= M; i++) {
            int[] cor = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x1 = cor[0];
            int y1 = cor[1];
            int x2 = cor[2];
            int y2 = cor[3];

            int ans = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];

            bw.write(String.valueOf(ans) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
