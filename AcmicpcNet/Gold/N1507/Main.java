package AcmicpcNet.Gold.N1507;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static boolean isFillWith(boolean[][] arr, boolean flag) {
        int N = arr.length - 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != flag) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[1+N][1+N];
        for (int i = 1; i <= N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                map[i],
                1,
                N
            );;
        }

        boolean[][] required = new boolean[1+N][1+N];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(required[i], true);
        }

        boolean valid = true;
        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (i == k || k == j) continue;
                    if (map[i][j] == (map[i][k] + map[k][j])) {
                        required[i][j] = false;
                    }
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        valid = false;
                        break;
                    }
                }
            }
        }

        int answer = 0;
        if (valid) {
            for (int i = 1; i <= N; i++) {
                for (int j = i+1; j <= N; j++) {
                    if (!required[i][j]) continue;
                    answer += map[i][j];
                }
            }
        } else {
            answer = -1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
