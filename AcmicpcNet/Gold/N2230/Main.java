package AcmicpcNet.Gold.N2230;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while (i <= j && i < A.length && j < A.length) {
            if (A[j] - A[i] >= M) {
                ans = Math.min(ans, A[j] - A[i]);
                i += 1;
            } else {
                j += 1;
            }
        }

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
    }
}
