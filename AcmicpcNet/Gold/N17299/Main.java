package AcmicpcNet.Gold.N17299;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] NGF = new int[N];
        Arrays.fill(NGF, -1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(A[stack.peek()]) <= map.get(A[i])) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NGF[i] = -1;
                stack.push(i);
            } else {
                NGF[i] = A[stack.peek()];
                if (map.get(A[i]) < map.get(A[stack.peek()])) {
                    stack.push(i);
                }
            }
        }

        String ans = Arrays.stream(NGF)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
