package AcmicpcNet.Bronze.N1075;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        String str = Integer.toString(N);
        int M = str.length();
        String first = str.substring(0, M-2);
        String ans = str.substring(M-2, M);

        for (int i = 0; i < 100; i++) {
            String last = String.format("%02d", i);
            int changed = Integer.parseInt(
                String.format("%s%s", first, last)
            );
            if (changed % K == 0) {
                ans = last;
                break;
            }
        }

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
