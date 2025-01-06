package AcmicpcNet.Gold.N7453;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];

        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int j = 0; j < 4; j++) {
                arr[j][i] = line[j];
            }
        }

        int[] AB = new int[N*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i * N + j] = arr[0][i] + arr[1][j];
            }
        }
        Arrays.sort(AB);

        int[] CD = new int[N*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                CD[i * N + j] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(CD);

        int i = 0;
        int j = N*N-1;
        long answer = 0;

        while (i < N*N && j >= 0) {
            int sum = AB[i] + CD[j];
            if (sum > 0) {
                j -= 1;
            } else if (sum == 0) {
                int ni = i;
                int nj = j;
                while (ni < N*N && AB[i] == AB[ni]) {
                    ni += 1;
                }
                while (nj >= 0 && CD[j] == CD[nj]) {
                    nj -= 1;
                }
                answer += ((long) j - nj) * ((long) ni - i);
                i = ni;
                j = nj;
            } else {
                i += 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
