package AcmicpcNet.Gold.N2629;

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

        int N = Integer.parseInt(br.readLine()); // 추의 개수
        int[] W = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray(); // 추

        int M = Integer.parseInt(br.readLine()); // 확인할 구슬 개수
        int[] B = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray(); // 구슬

        boolean[][] mem = new boolean[N][40001];
        mem[0][W[0]] = true;

        for (int i = 1; i < N; i++) {
            int w = W[i]; // 추 무게
            mem[i][w] = true;
            for (int j = 0; j < 40001; j++) {
                if (!mem[i-1][j]) continue;
                mem[i][j] = true;
                mem[i][Math.abs(j-w)] = true;
                mem[i][Math.abs(j+w)] = true;
            }
        }

        String answer = Arrays.stream(B)
            .mapToObj(ball -> mem[N-1][ball])
            .map(result -> result ? "Y" : "N")
            .collect(Collectors.joining(" "));

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}

