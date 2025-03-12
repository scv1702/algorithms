package AcmicpcNet.Gold.N14863;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0]; // 구간 개수
        int K = line[1]; // 여행 가능 시간

        int[][] map = new int[N][4];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        long[] mem = new long[1+K];
        Arrays.fill(mem, Long.MIN_VALUE);
        for (int j = 1; j <= K; j++) {
            if (j >= map[0][0]) {
                mem[j] = Math.max(mem[j], map[0][1]);
            }
            if (j >= map[0][2]) {
                mem[j] = Math.max(mem[j], map[0][3]);
            }
        }

        for (int i = 2; i <= N; i++) { // i: 현재 선택할 구간 번호
            for (int j = K; j >= 1; j--) { // j: 여행 가능 시간
                mem[j] = Long.MIN_VALUE;
                if (j >= map[i-1][0] && mem[j-map[i-1][0]] > 0) {
                    mem[j] = Math.max(mem[j], mem[j-map[i-1][0]] + map[i-1][1]);
                }
                if (j >= map[i-1][2] && mem[j-map[i-1][2]] > 0) {
                    mem[j] = Math.max(mem[j], mem[j-map[i-1][2]] + map[i-1][3]);
                }
            }
        }

        long answer = mem[K];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
