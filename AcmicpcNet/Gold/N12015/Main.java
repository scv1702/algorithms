package AcmicpcNet.Gold.N12015;

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
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] LIS = new int[N];
        int length = 1;
        LIS[0] = A[0];

        for (int i = 1; i < N; i++) {
            if (LIS[length-1] < A[i]) {
                LIS[length] = A[i];
                length += 1;
            } else {
                int idx = Arrays.binarySearch(LIS, 0, length, A[i]);
                if (idx < 0) {
                    int insertionPoint = -idx - 1;
                    LIS[insertionPoint] = A[i];
                }
            }
        }

        bw.write(String.valueOf(length));
        bw.flush();
        bw.close();
    }
}
