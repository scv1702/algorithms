package AcmicpcNet.Gold.N3151;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static long find(int[] A, int idx) {
        int N = A.length;
        int target = -A[idx];
        long res = 0;

        int left = idx+1;
        int right = N-1;

        while (left < right) {
            int sum = A[left] + A[right];
            if (sum > target) {
                right -= 1;
            } else if (sum == target) {
                if (A[left] == A[right]) {
                    int n = right - left;
                    res += n*(n+1) / 2;
                    break;
                } else {
                    int L = left;
                    while (A[left] == A[L]) {
                        left += 1;
                    }
                    int R = right;
                    while (A[right] == A[R]) {
                        right -= 1;
                    }
                    res += (left - L) * (R - right);
                }
            } else {
                left += 1;
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(A);

        long res = 0;
        for (int i = 0; i < N; i++) {
            res += find(A, i);
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
