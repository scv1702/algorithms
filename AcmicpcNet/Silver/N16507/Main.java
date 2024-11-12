package AcmicpcNet.Silver.N16507;

import java.io.*;
import java.util.Arrays;

// 배열 구간합
public class Main {

    private static int[] readLine(final BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] splited = br.readLine().split(" ");

        final int R = Integer.parseInt(splited[0]);
        final int C = Integer.parseInt(splited[1]);
        final int Q = Integer.parseInt(splited[2]);

        final int[][] picture = new int[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            final int[] lightness = readLine(br);
            System.arraycopy(lightness, 0, picture[i], 1, C);
        }

        final int[][] partialSum = new int[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                partialSum[i][j] = partialSum[i][j-1] + partialSum[i-1][j] - partialSum[i-1][j-1] + picture[i][j];
            }
        }

        for (int i = 0; i < Q; i++) {
            final int[] points = readLine(br);
            final int r1 = points[0];
            final int c1 = points[1];
            final int r2 = points[2];
            final int c2 = points[3];

            final int sum = (partialSum[r2][c2] - partialSum[r2][c1-1] - partialSum[r1-1][c2] + partialSum[r1-1][c1-1]);
            final int area = (r2 - r1 + 1) * (c2 - c1 + 1);

            bw.write(String.valueOf(sum / area));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
