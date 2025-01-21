package AcmicpcNet.Gold.N13144;

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
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int left = 0;
        int right = 0;
        int[] res = new int[N];
        boolean[] visited = new boolean[100_001];

        while (right < N && left <= right) {
            if (visited[A[right]]) {
                for (int i = left; i < right; i++) {
                    if (res[i] > 0) continue;
                    res[i] = i - left + 1;
                }
                visited[A[left]] = false;
                left += 1;
            } else {
                visited[A[right]] = true;
                right += 1;
            }
        }

        for (int i = left; i < right; i++) {
            if (res[i] > 0) continue;
            res[i] = i - left + 1;
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += res[i];
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
