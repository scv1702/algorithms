package AcmicpcNet.Bronze.N11050;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static int factorial(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int K = line[1];

        int ans = factorial(N) / (factorial(K) * factorial(N - K));

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
        bw.close();
    }
}
