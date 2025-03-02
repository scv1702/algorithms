package AcmicpcNet.Gold.N2056;

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

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> works = new ArrayList<>();
        works.add(List.of());
        for (int i = 1; i <= N; i++) {
            List<Integer> line = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            works.add(line);
        }

        int[] mem = new int[1+N];
        mem[1] = works.get(1).get(0);

        int answer = mem[1];
        for (int i = 2; i <= N; i++) {
            int t = 0;
            for (int j = 2; j <= 1 + works.get(i).get(1); j++) {
                t = Math.max(t, mem[works.get(i).get(j)]);
            }
            mem[i] = t + works.get(i).get(0);
            answer = Math.max(answer, mem[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
