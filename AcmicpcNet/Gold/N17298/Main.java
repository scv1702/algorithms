package AcmicpcNet.Gold.N17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        int[] B = new int[N];
        Stack<Integer> stack = new Stack<>();

        B[N-1] = -1;
        stack.push(A[N-1]);

        for (int i = N-2; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                B[i] = stack.peek();
            } else {
                B[i] = -1;
            }
            stack.push(A[i]);
        }

        String ans = Arrays.stream(B)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        bw.write(ans);
        bw.flush();
    }
}
