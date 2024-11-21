package AcmicpcNet.Gold.N2467;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")) // 정렬된 상태
            .mapToInt(Integer::parseInt)
            .toArray();

        // 두 정수의 합이 가장 0에 가까운 경우를 탐색
        // 완전 탐색을 하면 시간 초과
        // 투 포인터를 사용하자.

        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;

        int[] ans = new int[2];

        while (left < right) {
            int sum = Math.abs(A[left] + A[right]);
            if (sum < min) {
                min = sum;
                ans[0] = A[left];
                ans[1] = A[right];
            }
            if (left + 1 < right && left < right - 1 &&
                Math.abs(A[left+1] + A[right]) < Math.abs(A[left] + A[right-1])) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        Arrays.sort(ans);

        bw.write(String.format("%d %d\n", ans[0], ans[1]));
        bw.flush();
        bw.close();
    }
}
