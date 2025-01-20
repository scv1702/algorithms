package AcmicpcNet.Gold.N1011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static boolean isSquare(long num) {
        if (num < 0) return false;
        long sqrt = (long) Math.sqrt(num);
        return (sqrt * sqrt) == num;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int x = line[0];
            int y = line[1];
            long w = y - x;

            int res = 0;
            int h = (int) Math.sqrt(w);

            if (isSquare(w)) {
                res = 2 * h - 1;
            } else if ((long) h * (h + 1) >= w) {
                res = 2 * h;
            } else {
                res = 2 * h + 1;
            }

            bw.write(String.valueOf(res) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
