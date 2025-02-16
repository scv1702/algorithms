package AcmicpcNet.Gold.N2812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int K = line[1];

        int[] num = br.readLine()
            .chars()
            .map(n -> n - '0')
            .toArray();

        Stack<Integer> stack = new Stack<>();
        int k = K;
        stack.push(num[0]);
        for (int i = 1; i < N; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < num[i]) {
                stack.pop();
                k -= 1;
            }
            stack.push(num[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k -= 1;
        }
        for (int i = 0; i < N-K; i++) {
            sb.append(stack.pop());
        }
        sb.reverse();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
