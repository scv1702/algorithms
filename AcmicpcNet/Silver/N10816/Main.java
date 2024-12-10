package AcmicpcNet.Silver.N10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < N; i++) {
            map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] query = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String ans = Arrays.stream(query)
                .mapToObj(q -> map.getOrDefault(q, 0))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
