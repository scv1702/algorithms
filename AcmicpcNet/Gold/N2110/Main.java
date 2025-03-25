package AcmicpcNet.Gold.N2110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    // C: 설치할 공유기 개수
    // D: 두 공유기 사이 거리
    // H: 집 위치
    private static int count(
        int N, int[] H, int D
    ) {
        int count = 1;
        int prev = 0;

        for (int i = 1; i < N; i++) {
            int dist = H[i] - H[prev];
            if (dist >= D) {
                count += 1;
                prev = i;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0];
        int C = line[1];

        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(H);

        int left = 1;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(N, H, mid) >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int answer = right;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
