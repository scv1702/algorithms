package AcmicpcNet.Gold.N1918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    private static boolean isOperand(char c) {
        return "()*/+-".indexOf(c) < 0;
    }

    private static int rank(char c) {
        if (c == '*' || c == '/') return 0;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    private static String toPostfix(String infix) {
        int N = infix.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char c = infix.charAt(i);
            if (isOperand(c)) {
                sb.append(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty()) {
                        char pop = stack.pop();
                        if (pop == '(') break;
                        sb.append(pop);
                    }
                } else {
                    int rank = rank(c);
                    while (!stack.isEmpty()) {
                        char peek = stack.peek();
                        if (peek == '(') break;
                        int rankOfPeek = rank(peek);
                        if (rank < rankOfPeek) break;
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String infix = br.readLine();
        String postfix = toPostfix(infix);

        bw.write(postfix);
        bw.flush();
        bw.close();
    }
}
