package AcmicpcNet.Bronze.N10872;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1+N];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i] = i * dp[i-1];
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}
