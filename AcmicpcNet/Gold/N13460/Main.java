package AcmicpcNet.Gold.N13460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final int[][] dirs = {
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    public static List<int[]> permute(int n) {
        List<int[]> result = new ArrayList<>();
        permuteHelper(result, new int[n], -1, n, 0);
        return result;
    }

    private static void permuteHelper(List<int[]> result, int[] ids, int prev, int n, int depth) {
        if (depth >= n) {
            result.add(ids.clone());
            return ;
        }
        for (int i = 0; i < dirs.length; i++) {
            if (i == prev) continue;
            if (prev == -1 || i % 2 != prev % 2) {
                ids[depth] = i;
                permuteHelper(result, ids, i, n, depth + 1);
            }
        }
    }

    public static boolean insides(char[][] map, int i, int j) {
        return i >= 0 && i < map.length && j >= 0 && j < map[0].length;
    }

    public static char[][] clone(char[][] array) {
        char[][] res = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                res[i][j] = array[i][j];
            }
        }
        return res;
    }

    public static void logs(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(String.valueOf(map[i]));
        }
        System.out.println();
    }

    public static boolean visitable(char[][] map, int i, int j) {
        return insides(map, i, j) && map[i][j] == '.';
    }

    public static boolean escaped(int[] hole, int i, int j) {
        return hole[0] == i && hole[1] == j;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                br.readLine().toCharArray(),
                0,
                map[i],
                0,
                M
            );
        }

        int[] red = new int[2];
        int[] blue = new int[2];
        int[] hole = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                } else if (map[i][j] == 'O') {
                    hole[0] = i;
                    hole[1] = j;
                    map[i][j] = '.';
                }
            }
        }

        List<int[]> permutations = permute(10);
        int ans = Integer.MAX_VALUE;

        for (int[] permutation : permutations) {
            int ri = red[0];
            int rj = red[1];

            int bi = blue[0];
            int bj = blue[1];

            char[][] temp = clone(map);

            for (int d = 0; d < permutation.length; d++) {
                int dir = permutation[d];

                int rni = ri + dirs[dir][0];
                int rnj = rj + dirs[dir][1];

                int bni = bi + dirs[dir][0];
                int bnj = bj + dirs[dir][1];

                while (visitable(temp, rni, rnj) || visitable(temp, bni, bnj)) {
                    // 공이 이동 가능한 경우, 이동
                    if (visitable(temp, rni, rnj)) {
                        temp[ri][rj] = '.';
                        ri = rni;
                        rj = rnj;
                        temp[ri][rj] = 'R';
                        rni = ri + dirs[dir][0];
                        rnj = rj + dirs[dir][1];
                    }

                    if (escaped(hole, ri, rj)) {
                        temp[ri][rj] = '.'; // 공이 빠진다.
                    }

                    if (visitable(temp, bni, bnj)) {
                        temp[bi][bj] = '.';
                        bi = bni;
                        bj = bnj;
                        temp[bi][bj] = 'B';
                        bni = bi + dirs[dir][0];
                        bnj = bj + dirs[dir][1];
                    }

                    if (escaped(hole, bi, bj)) {
                        temp[bi][bj] = '.';
                    }

                    if (escaped(hole, ri, rj) || escaped(hole, bi, bj)) {
                        break;
                    }
                }

                if (escaped(hole, bi, bj)) break;
                if (!escaped(hole, ri, rj)) continue;

                while (visitable(temp, bni, bnj)) {
                    // 공이 이동 가능한 경우, 이동
                    if (visitable(temp, bni, bnj)) {
                        temp[bi][bj] = '.';
                        bi = bni;
                        bj = bnj;
                        temp[bi][bj] = 'B';
                        bni = bi + dirs[dir][0];
                        bnj = bj + dirs[dir][1];
                    }

                    if (escaped(hole, bi, bj)) {
                        temp[bi][bj] = '.';
                        break;
                    }
                }

                if (!escaped(hole, bi, bj)) {
                    ans = Math.min(ans, d+1);
                    break;
                }

            }
        }

        if (ans == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(String.valueOf(ans) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
