import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.peekLast() == c) {
                stack.pollLast();
            } else {
                stack.offerLast(c);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }

    public int solution(String s) {
        // 짝지어 제거했을 때 모두 제거할 수 있을까?
        // () 판별 문제랑 비슷한듯?
        // 문자 c로 시작했으면 문자 c로 닺혀야 함
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
