package AcmicpcNet.Silver.N30804;

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
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<List<Integer>> comb = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            List<Integer> c = new ArrayList<>();
            c.add(i);
            comb.add(c);
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = i+1; j <= 9; j++) {
                List<Integer> c = new ArrayList<>();
                c.add(i);
                c.add(j);
                comb.add(c);
            }
        }

        int ans = Integer.MIN_VALUE;

        for (List<Integer> fruit : comb) {
            int res = 0;
            for (int i = 0; i < N; i++) {
                if (fruit.contains(arr[i])) {
                    res += 1;
                } else {
                    ans = Math.max(ans, res);
                    res = 0;
                }
            }
            ans = Math.max(ans, res);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
