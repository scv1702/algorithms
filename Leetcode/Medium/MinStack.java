package Leetcode.Medium;

public class MinStack {
    class Node {
        int val;
        int idx;
        Node next;
        Node nextMin;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node top = null;
    Node min = null;
    
    public MinStack() { 
    }
    
    public void push(int val) {
        if (top == null) {
            Node newNode = new Node(val, null);
            top = newNode;
            min = newNode;
            return ;
        }
        Node newNode = new Node(val, top);
        top = newNode;
        if (val < min.val) {
            newNode.nextMin = min;
            min = newNode;
        }
    }
    
    public void pop() {
        if (top == min) min = min.nextMin;
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return min.val;
    }
}