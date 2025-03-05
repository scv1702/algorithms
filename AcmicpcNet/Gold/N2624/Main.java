package AcmicpcNet.Gold.N2624;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    private static final int PRICE = 0;
    private static final int COUNT = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 지폐 금액
        int k = Integer.parseInt(br.readLine()); // 동전의 가지 수

        int[][] P = new int[k][2];
        for (int i = 0; i < k; i++) {
            P[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        Arrays.sort(P, Comparator.comparingInt(p -> p[0]));

        int[][] mem = new int[k][1+T];
        for (int i = 1; i <= P[0][COUNT]; i++) {
            if (P[0][PRICE] * i > T) break;
            mem[0][P[0][PRICE] * i] += 1;
        }

        for (int i = 1; i < k; i++) {
            int price = P[i][PRICE];
            int count = P[i][COUNT];
            mem[i] = Arrays.copyOf(mem[i-1], 1+T);
            for (int j = 1; j <= count; j++) {
                if (price * j > T) break;
                mem[i][price * j] += 1;
            }
            for (int m = 0; m <= T; m++) {
                if (mem[i-1][m] <= 0) continue;
                for (int j = 1; j <= count; j++) {
                    if (m + price * j > T) break;
                    mem[i][m + price * j] += mem[i-1][m];
                }
            }
        }

        bw.write(String.valueOf(mem[k-1][T]));
        bw.flush();
        bw.close();
    }
}

