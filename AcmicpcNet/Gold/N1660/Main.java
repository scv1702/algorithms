package AcmicpcNet.Gold.N1660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] C = new int[1+N];
        int M = 0;
        for (int i = 1; i <= N; i++) {
            int curr =  C[i-1] + i * (i+1)/2;
            if (curr > N) break;
            C[i] = curr;
            M = i;
        }

        int[] mem = new int[1+N];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i < C[j]) break;
                mem[i] = Math.min(mem[i-C[j]] + 1, mem[i]);
            }
        }

        int answer = mem[N];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
