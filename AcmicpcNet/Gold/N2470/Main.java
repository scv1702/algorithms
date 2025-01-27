package AcmicpcNet.Gold.N2470;

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

        Arrays.sort(A);

        int[] ans = new int[2];

        if (A[0] > 0) {
            ans[0] = A[0];
            ans[1] = A[1];
        } else if (A[0] < 0 && A[N-1] < 0) {
            ans[0] = A[N-2];
            ans[1] = A[N-1];
        } else {
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int target = -A[i];
                int idx = Arrays.binarySearch(A, target);
                if (idx >= 0) {
                    if (i < idx) {
                        ans[0] = A[i];
                        ans[1] = A[idx];
                    } else {
                        ans[0] = A[idx];
                        ans[1] = A[i];
                    }
                    break;
                } else {
                    idx = -idx - 1;
                    if (i != idx && idx < N && Math.abs(A[i] + A[idx]) < minSum) {
                        minSum = Math.abs(A[i] + A[idx]);
                        if (i < idx) {
                            ans[0] = A[i];
                            ans[1] = A[idx];
                        } else {
                            ans[0] = A[idx];
                            ans[1] = A[i];
                        }
                    }
                    if (i != idx-1 && idx-1 >= 0 && Math.abs(A[i] + A[idx-1]) < minSum) {
                        minSum = Math.abs(A[i] + A[idx-1]);
                        if (i < idx-1) {
                            ans[0] = A[i];
                            ans[1] = A[idx-1];
                        } else {
                            ans[0] = A[idx-1];
                            ans[1] = A[i];
                        }
                    }
                    if (i != idx+1 && idx+1 < N && Math.abs(A[i] + A[idx+1]) < minSum) {
                        minSum = Math.abs(A[i] + A[idx+1]);
                        if (i < idx+1) {
                            ans[0] = A[i];
                            ans[1] = A[idx+1];
                        } else {
                            ans[0] = A[idx+1];
                            ans[1] = A[i];
                        }
                    }
                }
            }
        }

        bw.write(String.format("%d %d\n", ans[0], ans[1]));
        bw.flush();
        bw.close();
    }
}
