package AcmicpcNet.Gold.N11058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static long max(long... arr) {
        return Arrays.stream(arr)
            .max()
            .orElse(0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] mem = new long[1+N];

        for (int i = 1; i <= N; i++) {
            if (i <= 6) {
                mem[i] = i;
            } else {
                mem[i] = max(
                    2 * mem[i - 3],
                    3 * mem[i - 4],
                    4 * mem[i - 5],
                    5 * mem[i - 6]
                );
            }
        }

        bw.write(String.valueOf(mem[N]));
        bw.flush();
        bw.close();
    }
}
