package AcmicpcNet.Gold.N2631;

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

        int[] A = new int[1+N];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int[] LIS = new int[1+N];
        int j = 0;
        for (int i = 1; i <= N; i++) {
            if (LIS[j] < A[i]) {
                LIS[j+1] = A[i];
                j += 1;
            } else {
                int idx = Arrays.binarySearch(LIS, 1, j+1, A[i]);
                LIS[-idx-1] = A[i];
            }
        }

        int answer = N - j;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

