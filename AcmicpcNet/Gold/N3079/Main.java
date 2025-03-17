package AcmicpcNet.Gold.N3079;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static boolean isPossible(int[] T, long M, long time) {
        long res = 0;
        for (long t : T) {
            res += time / t;
            if (res >= M) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0]; // 입국 심사대 개수
        int M = line[1]; // 친구 수

        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = 1_000_000_000_000_000_000L;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (isPossible(T, M, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}
