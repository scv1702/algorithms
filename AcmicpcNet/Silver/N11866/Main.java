package AcmicpcNet.Silver.N11866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int K = line[1];

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        int[] res = new int[N];
        int j = 0;

        for (int i = 0; i < N; i++) {
            j = (j + K-1) % arr.size();
            res[i] = arr.get(j);
            arr.remove(j);
        }

        String ans = "<" +
                Arrays.stream(res)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", ")) +
                ">";

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
