package AcmicpcNet.Silver.N2531;

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

        int N = line[0]; // 접시 수
        int d = line[1]; // 초밥 가짓수
        int k = line[2]; // 연속해서 먹는 접시 수
        int c = line[3]; // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        int sushi = 1;
        int[] visited = new int[1+d];
        visited[c] = 1;

        for (; i < k; i++) {
            if (visited[belt[i]] == 0) {
                sushi += 1;
            }
            visited[belt[i]] += 1;
        }

        int ans = sushi;
        for (i = k; i < N + k; i++) {
            int left = (i-k) % N;
            if (belt[left] != c) {
                if (visited[belt[left]] == 1) {
                    sushi -= 1;
                }
                visited[belt[left]] -= 1;
            }
            int right = i % N;
            if (visited[belt[right]] == 0) {
                sushi += 1;
            }
            visited[belt[right]] += 1;
            ans = Math.max(ans, sushi);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
