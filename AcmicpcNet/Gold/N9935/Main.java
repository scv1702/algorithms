package AcmicpcNet.Gold.N9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int S = 0;
    private static int B = 0;

    private static boolean isBomb(String s, int end, String b, int[] prev, boolean[] exploded) {
        if (end + 1 - B < 0) return false;

        int i = end;
        int j = B-1;

        while (j >= 0) {
            if (i < 0) {
                return false;
            }
            if (!exploded[i]) {
                if (s.charAt(i) != b.charAt(j)) {
                    return false;
                }
                j -= 1;
            }
            i = prev[i];
        }

        return true;
    }

    private static void explode(int[] prev, boolean[] exploded, int end) {
        int i = end;

        for (int j = 0; j < B; j++) {
            if (i < 0) {
                break;
            }
            exploded[i] = true;
            i = prev[i];
        }

        if (end + 1 < S) {
            prev[end + 1] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String b = br.readLine();

        S = s.length();
        B = b.length();

        int[] prev = new int[S];
        for (int i = 0; i < S; i++) {
            prev[i] = i-1;
        }

        boolean[] exploded = new boolean[S];

        int i = B-1;
        while (i < S) {
            if (!exploded[i]) {
                if (isBomb(s, i, b, prev, exploded)) {
                    explode(prev, exploded, i);
                }
            }
            i += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < S; i++) {
            if (!exploded[i]) {
                sb.append(s.charAt(i));
            }
        }

        String res = sb.toString();
        String ans = res.isEmpty() ? "FRULA" : res;

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
