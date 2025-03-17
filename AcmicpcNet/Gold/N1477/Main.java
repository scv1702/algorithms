package AcmicpcNet.Gold.N1477;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static boolean isPossible(List<Integer> R, int M, int len) {
        int N = R.size();
        int res = 0;
        for (int i = 1; i < N; i++) {
            int dist = R.get(i) - R.get(i-1);
            if (dist <= len) continue;
            if (dist % len == 0) {
                res += (dist / len) - 1;
            } else {
                res += (dist / len);
            }
        }
        return res <= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = line[0]; // 휴개소 개수
        int M = line[1]; // 더 지으려는 휴게소 개수
        int L = line[2]; // 고속도로 길이

        List<Integer> R = new ArrayList<>();
        R.add(0);

        String str = br.readLine();
        if (!str.isEmpty()) {
            line = Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
            for (int i = 0; i < N; i++) {
                R.add(line[i]);
            }
        }
        R.add(L);

        int start = 1;
        int end = 1000;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(R, M, mid)) {
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
