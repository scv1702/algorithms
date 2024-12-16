package AcmicpcNet.Gold.N9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class UsingStack {

    private static int S = 0;
    private static int B = 0;

    private static boolean isBomb(Stack<Character> stack, String b) {
        int size = stack.size();
        if (size < B) return false;

        for (int j = 0; j < B; j++) {
            if (stack.get(size - 1 - j) != b.charAt(B - 1 - j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String b = br.readLine();

        S = s.length();
        B = b.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S; i++) {
            char c = s.charAt(i);
            stack.push(c);
            if (isBomb(stack, b)) {
                for (int j = 0; j < B; j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String res = sb.reverse().toString();
        String ans = res.isEmpty() ? "FRULA" : res;

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
