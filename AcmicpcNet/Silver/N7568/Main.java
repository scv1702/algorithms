package AcmicpcNet.Silver.N7568;

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
        int[][] arr = new int[N][2];
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            arr[i][0] = line[0];
            arr[i][1] = line[1];
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    rank += 1;
                }
            }
            ans[i] = rank;
        }

        String res = Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(res);
        bw.flush();
        bw.close();
    }
}
