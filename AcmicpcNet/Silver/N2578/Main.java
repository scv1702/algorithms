package AcmicpcNet.Silver.N2578;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        int SIZE = 5;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();

        int[][] arr = new int[SIZE][SIZE];
        boolean[][] v = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = line[j];
                map.put(arr[i][j], i * SIZE + j);
            }
        }

        int[] query = new int[SIZE * SIZE];
        for (int i = 0; i < SIZE; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            System.arraycopy(line, 0, query, i * SIZE, SIZE);
        }

        for (int q = 0; q < query.length; q++) {
            int n = query[q];
            int r = map.get(n) / SIZE;
            int c = map.get(n) % SIZE;
            int cnt = 0;
            int i = 0;
            int j = 0;

            v[r][c] = true;

            // 가로
            for (i = 0; i < SIZE; i++) {
                boolean bingo = true;
                for (j = 0; j < SIZE; j++) {
                    if (!v[i][j]) {
                        bingo = false;
                        break;
                    }
                }
                if (bingo) {
                    cnt += 1;
                }
            }

            // 세로
            for (j = 0; j < SIZE; j++) {
                boolean bingo = true;
                for (i = 0; i < SIZE; i++) {
                    if (!v[i][j]) {
                        bingo = false;
                        break;
                    }
                }
                if (bingo) {
                    cnt += 1;
                }
            }

            // (0, 0)에서 (SIZE-1, SIZE-1) 대각선
            boolean bingo = true;
            for (i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {
                if (!v[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                cnt += 1;
            }

            // (0, SIZE-1)에서 (SIZE-1, 0) 대각선
            bingo = true;
            for (i = 0, j = SIZE-1; i < SIZE && j >= 0; i++, j--) {
                if (!v[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                cnt += 1;
            }

            if (cnt >= 3) {
                bw.write(String.valueOf(q + 1));
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
