package AcmicpcNet.Silver.N9655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = true;

        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0) {
                dp[i] = !dp[i-3];
            } else {
                dp[i] = !dp[i-1];
            }
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
