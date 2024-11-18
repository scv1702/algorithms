package AcmicpcNet.Silver.N13335;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int W = line[1]; // 다리 길이
        int L = line[2]; // 다리 최대 하중

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<int[]> bridge = new ArrayDeque<>();

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        int sum = 0; // sum은 L보다 작거나 같아야 한다.
        int t = 1;
        for (; !bridge.isEmpty() || !queue.isEmpty(); t++) {
            if (!bridge.isEmpty()) {
                int weight = bridge.peek()[0];
                int out = bridge.peek()[1];
                if (out <= t) {
                    sum -= weight;
                    bridge.poll();
                }
            }

            int out = t + W;
            if (!queue.isEmpty()) {
                int weight = queue.peek();
                if (sum + weight <= L) {
                    sum += weight;
                    queue.poll();
                    bridge.offer(new int[] { weight, out });
                }
            }
        }

        bw.write(String.valueOf(t - 1) + '\n');
        bw.flush();
        bw.close();
    }
}
