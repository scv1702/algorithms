package AcmicpcNet.Gold.N1806;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int S = line[1];

        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sum = new int[1+N];

        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + A[i];
        }

        int left = 0;
        int right = 1;
        int ans = Integer.MAX_VALUE;

        while (left < right && right <= N) {
            if (sum[right] - sum[left] >= S) {
                ans = Math.min(ans, right - left);
                left += 1;
            } else {
                right += 1;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            bw.write("0\n");
        } else {
            bw.write(String.valueOf(ans) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
