package AcmicpcNet.Gold.N30805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static void solve(List<Integer> res, int[] A, int fromA, int[] B, int fromB) {
        int N = A.length;
        int M = B.length;

        int max = 0;
        int nextA = -1;
        int nextB = -1;

        for (int i = fromA; i < N; i++) {
            for (int j = fromB; j < M; j++) {
                if (A[i] == B[j] && max < A[i]) {
                    max = A[i];
                    nextA = i+1;
                    nextB = j+1;
                }
            }
        }

        if (max > 0) {
            res.add(max);
            solve(res, A, nextA, B, nextB);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> res = new ArrayList<>();
        solve(res, A, 0, B, 0);

        int K = res.size();
        String str = res.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(String.valueOf(K) + '\n');
        bw.write(str);
        bw.flush();
        bw.close();
    }
}
