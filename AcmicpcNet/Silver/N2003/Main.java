package AcmicpcNet.Silver.N2003;

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
        int M = line[1];

        int[] A = new int[1+N];
        line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        System.arraycopy(line, 0, A, 1, N);

        int[] S = new int[1+N];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + A[i];
        }

        int left = 1;
        int right = 1;
        int res = 0;
        while (right <= N && left <= right) {
            int s = S[right] - S[left-1];
            if (s < M) {
                right += 1;
            } else if (s == M) {
                res += 1;
                left += 1;
                right += 1;
            } else {
                left += 1;
                if (left > right) {
                    right = left;
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
