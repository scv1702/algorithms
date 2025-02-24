package AcmicpcNet.Gold.N13164;

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
        int N = line[0]; // 원생 수
        int K = line[1]; // 조 개수

        int[] C = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray(); // 정렬된 상태

        int[] diff = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = C[i+1] - C[i];
        }

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < N-K; i++) {
            answer += diff[i];
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
