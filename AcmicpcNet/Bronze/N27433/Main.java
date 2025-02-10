package AcmicpcNet.Bronze.N27433;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long ans = 1;
        for (int i = 2; i <= N; i++) {
            ans = ans * i;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
