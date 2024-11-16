package AcmicpcNet.Gold.N18808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static int[][] rotate(int[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;
        int[][] res = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[j][r-1-i] = sticker[i][j];
            }
        }
        return res;
    }

    public static boolean isAttachable(boolean[][] attached, int nr, int nc, int[][] sticker) {
        for (int sr = 0; sr < sticker.length; sr++) {
            for (int sc = 0; sc < sticker[0].length; sc++) {
                if (sticker[sr][sc] != 1) continue;
                if (nr + sr < 0 || nr + sr >= attached.length) return false;
                if (nc + sc < 0 || nc + sc >= attached[0].length) return false;
                if (attached[nr + sr][nc + sc]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void attache(boolean[][] attached, int nr, int nc, int[][] sticker) {
        for (int sr = 0; sr < sticker.length; sr++) {
            for (int sc = 0; sc < sticker[0].length; sc++) {
                if (sticker[sr][sc] != 1) continue;
                attached[nr + sr][nc + sc] = true;
            }
        }
    }

    public static boolean findAndAttache(boolean[][] attached, int[][] sticker) {
        for (int nr = 0; nr < attached.length; nr++) {
            for (int nc = 0; nc < attached[0].length; nc++) {
                if (isAttachable(attached, nr, nc, sticker)) {
                    attache(attached, nr, nc, sticker);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        boolean[][] attached = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int ri = Integer.parseInt(line[0]);
            int ci = Integer.parseInt(line[1]);

            int[][] sticker = new int[ri][ci];
            for (int r = 0; r < ri; r++) {
                int[] st = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                System.arraycopy(st, 0, sticker[r], 0, ci);
            }

            for (int j = 0; j < 4; j++) {
                if (!findAndAttache(attached, sticker)) {
                    sticker = rotate(sticker);
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (attached[i][j]) {
                    ans += 1;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
