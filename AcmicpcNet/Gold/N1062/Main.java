package AcmicpcNet.Gold.N1062;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int ans = 0;
    private static final String DICT = "bdefghjklmopqrsuvwxyz";

    private static boolean readable(String word, boolean[] dict) {
        int W = word.length();
        for (int j = 0; j < W; j++) {
            char c = word.charAt(j);
            if (!dict[c - 'a']) return false;
        }
        return true;
    }

    private static void solve(String[] words, boolean[] dict, int K, int prev) {
        int N = words.length;
        int M = DICT.length();

        if (K <= 0) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (readable(words[i], dict)) {
                    count += 1;
                }
            }
            ans = Math.max(ans, count);
            return ;
        }

        for (int i = prev; i < M; i++) {
            char d = DICT.charAt(i);
            if (!dict[d - 'a']) {
                dict[d - 'a'] = true;
                solve(words, dict, K-1, i);
                dict[d - 'a'] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int K = line[1];

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K >= 5) {
            boolean[] dict = new boolean[26];
            for (char c : "antic".toCharArray()) {
                dict[c - 'a'] = true;
            }
            solve(words, dict, K-5, 0);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
