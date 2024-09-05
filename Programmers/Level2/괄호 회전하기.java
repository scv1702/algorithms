import java.util.*;

class Solution {
    public String shiftToLeft(String s, int t) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = t; i < t + n; i++) {
            sb.append(s.charAt(i % n));
        }
        return sb.toString();
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char peek = stack.peek();
                if (c == ')' && peek != '(') {
                    return false;
                }
                if (c == ']' && peek != '[') {
                    return false;
                }
                if (c == '}' && peek != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    // O(n^2)
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) { // i = 0 to n O(n)
            // 1. shift to left O(n)
            // 2. is valid? O(n)
            if (isValid(shiftToLeft(s, i))) {
                answer += 1;
            }
        }
        return answer;
    }
}
