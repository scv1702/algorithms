package AcmicpcNet.Gold.N2224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int toInt(String s) {
        char c = s.charAt(0);
        if (Character.isUpperCase(c)) {
            return c - 'A';
        }
        return c - 'a' + 26;
    }

    private static char toChar(int n) {
        if (n < 26) {
            return (char) (n + 'A');
        }
        return (char) (n - 26 + 'a');
    }

    private static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[52][52];
        for (int i = 0; i < 52; i++) {
            Arrays.fill(map[i], 987654321);
            map[i][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            int[] splited = Arrays.stream(br.readLine().split("=>"))
                .map(String::trim)
                .mapToInt(Main::toInt)
                .toArray();
            int u = splited[0];
            int v = splited[1];
            map[u][v] = 1;
        }

        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 52; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i == j) continue;
                if (map[i][j] != INF) {
                    count += 1;
                    sb.append(String.format("%s => %s\n", toChar(i), toChar(j)));
                }
            }
        }

        bw.write(String.format("%d\n", count));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
