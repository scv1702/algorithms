package AcmicpcNet.Gold.N1644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1+N];

        Arrays.fill(prime, true);

        for (int i = 2; i * i <= N; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Long> sum = new ArrayList<>();

        sum.add(0L);

        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                sum.add(sum.get(sum.size() - 1) + i);
            }
        }

        int ans = 0;
        int left = 0;
        int right = 1;

        while (left < right && right < sum.size()) {
            long k = sum.get(right) - sum.get(left);
            if (k < N) {
                right += 1;
            } else if (k == N) {
                ans += 1;
                left += 1;
            } else {
                left += 1;
            }
        }

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
        bw.close();
    }
}
