package AcmicpcNet.Gold.N3980;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int answer;

    private static void solve(int[][] S, int[] P, int depth) {
        int N = S.length;

        if (depth >= N) {
            answer = Math.max(answer, Arrays.stream(P).sum());
            return ;
        }

        for (int j = 0; j < 11; j++) {
            if (S[depth][j] <= 0) continue;
            if (P[j] > 0) continue;
            P[j] = S[depth][j];
            solve(S, P, depth + 1);
            P[j] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            int[][] S = new int[11][11];
            for (int i = 0; i < 11; i++) {
                S[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            }

            int[] P = new int[11];
            answer = Integer.MIN_VALUE;

            solve(S, P, 0);

            bw.write(String.format("%d\n", answer));
        }

        bw.flush();
        bw.close();
    }
}

