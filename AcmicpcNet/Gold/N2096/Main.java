package AcmicpcNet.Gold.N2096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            System.arraycopy(
                Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(),
                0,
                arr[i],
                0,
                3
            );
        }

        int[] min = new int[3];
        int[] max = new int[3];

        min[0] = max[0] = arr[0][0];
        min[1] = max[1] = arr[0][1];
        min[2] = max[2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            int[] prev = new int[3];
            System.arraycopy(
                min, 0, prev, 0, 3
            );
            prev[0] = Math.min(min[0], min[1]) + arr[i][0];
            prev[1] = Math.min(min[0], Math.min(min[1], min[2])) + arr[i][1];
            prev[2] = Math.min(min[1], min[2]) + arr[i][2];
            System.arraycopy(
                prev, 0, min, 0, 3
            );

            System.arraycopy(
                max, 0, prev, 0, 3
            );
            prev[0] = Math.max(max[0], max[1]) + arr[i][0];
            prev[1] = Math.max(max[0], Math.max(max[1], max[2])) + arr[i][1];
            prev[2] = Math.max(max[1], max[2]) + arr[i][2];
            System.arraycopy(
                prev, 0, max, 0, 3
            );
        }

        int[] res = new int[2];
        res[0] = Math.max(max[0], Math.max(max[1], max[2]));
        res[1] = Math.min(min[0], Math.min(min[1], min[2]));

        String ans = Arrays.stream(res)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
