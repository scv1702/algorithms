package AcmicpcNet.Gold.N2473;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] ans = new long[3];

        Arrays.sort(nums);

        long sum = Long.MAX_VALUE;

        for (int i = 0; i < N-2; i++) {
            int j = i+1;
            int k = N-1;
            while (j < k) {
                long s = nums[i] + nums[j] + nums[k];
                if (Math.abs(s) < sum) {
                    sum = Math.abs(s);
                    ans[0] = nums[i];
                    ans[1] = nums[j];
                    ans[2] = nums[k];
                }
                if (s < 0) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }

        bw.write(String.format("%d %d %d\n", ans[0], ans[1], ans[2]));
        bw.flush();
        bw.close();
    }
}
