package AcmicpcNet.Silver.N2669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] coordinates = new int[100][100];
        for (int i = 0; i < 4; i++) {
            int[] square = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            // (x0, y0) (x1, y1)
            int x0 = square[0];
            int y0 = square[1];
            int x1 = square[2];
            int y1 = square[3];
            for (int x = x0; x < x1; x++) {
                for (int y = y0; y < y1; y++) {
                    coordinates[x][y] = 1;
                }
            }
        }

        int ans = 0;
        for (int x = 0; x < coordinates.length; x++) {
            for (int y = 0; y < coordinates.length; y++) {
                if (coordinates[x][y] == 1) {
                    ans += 1;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
