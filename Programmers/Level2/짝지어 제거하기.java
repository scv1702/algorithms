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
}
