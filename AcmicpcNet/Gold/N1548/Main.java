package AcmicpcNet.Gold.N1548;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int ans = 1;

    private static void solve(int[] A, int i, int f, int s, int prev) {
        int N = A.length;

        if (i >= N) {
            return ;
        }

        if (A[i] < f + s) {
            ans = Math.max(ans, prev + 1);
            solve(A, i+1, f, s, prev + 1);
        } else {
            solve(A, i+1, f, s, prev);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (N >= 2) {
            ans = 2;
            Arrays.sort(A);
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    solve(A, j+1, A[i], A[j], 2);
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
