package AcmicpcNet.Bronze.N1032;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            result[i] = br.readLine();
        }

        int M = result[0].length();
        String ans = result[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result[i].charAt(j) != ans.charAt(j)) {
                    char[] chars = ans.toCharArray();
                    chars[j] = '?';
                    ans = new String(chars);
                }
            }
        }

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
