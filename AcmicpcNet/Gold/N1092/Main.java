package AcmicpcNet.Gold.N1092;

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
        int[] C = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(C);
        Arrays.sort(B);

        int t = 0;

        int[] counts = new int[N];

        for (int i = M-1; i >= 0; i--) {
            int k = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (B[i] <= C[j]) {
                    if (counts[j] < min) {
                        min = counts[j];
                        k = j;
                    }
                }
            }
            if (k < 0) {
                t = -1;
                break;
            }
            counts[k] += 1;
            t = Math.max(t, counts[k]);
        }

        String ans = String.valueOf(t);

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
