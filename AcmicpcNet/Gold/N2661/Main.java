package AcmicpcNet.Gold.N2661;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int[] res;
    private static String answer = "";

    private static String toString(int[] arr) {
        int N = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static boolean isSame(int[] res, int s1, int s2, int len) {
        int N = res.length;

        if (s1 + len > N || s2 + len > N) {
            return false;
        }

        for (
            int i = s1, j = s2;
            i < s1 + len && j < s2+len;
            i++, j++
        ) {
            if (res[i] != res[j]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPossible(int[] res, int len) {
        for (int l = 2; l < len; l++) {
            for (int k = 0; k <= len-2*l; k++) {
                if (isSame(res, k, k+l, l)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(int N, int depth) {
        if (depth >= N) {
            answer = toString(res);
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            if (depth < 1 || res[depth-1] != i) {
                res[depth] = i;
                if (!isPossible(res, depth+1)) {
                    continue;
                }
                if (solve(N, depth+1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        res = new int[N];
        solve(N, 0);

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
