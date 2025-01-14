package AcmicpcNet.Silver.N9657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[Math.max(5, 1+N)];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;

        for (int i = 5; i <= N; i++) {
            dp[i] = !dp[i-1] || !dp[i-3] || !dp[i-4];
        }

        if (dp[N]) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }

        bw.flush();
        bw.close();
    }
}
