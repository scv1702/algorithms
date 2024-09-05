package Leetcode.Easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> primary;
        Stack<Integer> secondary;
        boolean reversed;

        public void reverse(Stack<Integer> s1, Stack<Integer> s2) {
            while (!s1.isEmpty()) s2.push(s1.pop());
            this.reversed = !this.reversed;
        }

        public MyQueue() {
            this.primary = new Stack<>();
            this.secondary = new Stack<>();
        }
        
        public void push(int x) {
            if (reversed) reverse(secondary, primary);
            primary.push(x);
        }
        
        public int pop() {
            if (!reversed) reverse(primary, secondary);
            return secondary.pop();
        }
        
        public int peek() {
            if (!reversed) reverse(primary, secondary);
            return secondary.peek();
        }
        
        public boolean empty() {
            return primary.isEmpty() && secondary.isEmpty();
        }
    }
}
