package AcmicpcNet.Silver.N4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        while (!".".equals(s)) {
            Stack<Character> stack = new Stack<>();
            String ans = "yes";

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        ans = "no";
                        break;
                    }
                    char d = stack.pop();
                    if (d != '(') {
                        ans = "no";
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty()) {
                        ans = "no";
                        break;
                    }
                    char d = stack.pop();
                    if (d != '[') {
                        ans = "no";
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                ans = "no";
            }

            bw.write(ans + '\n');
            s = br.readLine();
        }

        bw.flush();
        bw.close();
    }
}
