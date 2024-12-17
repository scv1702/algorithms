package AcmicpcNet.Gold.N13172;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int X = 1_000_000_007;

    private static long pow(long n, long k) {
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        long half = (pow(n, k / 2)) % X;
        long halfPow = (half * half) % X;
        return (k % 2 == 0) ? halfPow : (halfPow * n) % X;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        long s = 0;

        for (int i = 0; i < M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            long b = line[0]; // N
            long a = line[1]; // S
            long bi = pow(b, X-2) % X;
            s += (a * bi) % X;
        }

        bw.write(String.valueOf(s % X));
        bw.flush();
        bw.close();
    }
}
