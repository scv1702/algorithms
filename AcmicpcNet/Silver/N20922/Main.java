package AcmicpcNet.Silver.N20922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int K = line[1];
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] visited = new int[100_001];
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < N && left <= right) {
            if (visited[A[right]] >= K) {
                visited[A[left]] -= 1;
                left += 1;
            } else {
                ans = Math.max(ans, right - left + 1);
                visited[A[right]] += 1;
                right += 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
