package Leetcode.Hard;

public class DinnerPlateStacks {
    class CustomStack {
        int[] stack;
        int top;
        int index;
        CustomStack prev = null;
        CustomStack next = null;
    
        public CustomStack(int index, int capacity, CustomStack prev, CustomStack next) {
            this.index = index;
            this.stack = new int[capacity];
            this.prev = prev;
            this.next = next;
            this.top = -1;
        }
    
        public void push(int val) {
            if (isFull()) return ;
            stack[++top] = val;
        }
    
        public int pop() {
            if (isEmpty()) return -1;
            return stack[top--];
        }
    
        public boolean isFull() {
            return top >= stack.length-1;
        }
    
        public boolean isEmpty() {
            return top < 0;
        }    
    }
    
    class DinnerPlates {
        CustomStack headStack;
        CustomStack leftMostNotFullStack;
        CustomStack rightMostNotEmptyStack;
        int capacity;
        int size;
    
        public DinnerPlates(int capacity) {
            CustomStack newStack = new CustomStack(this.size++, capacity, null, null);
            this.headStack = newStack;
            this.leftMostNotFullStack = newStack;
            this.rightMostNotEmptyStack = newStack;
            this.capacity = capacity;
        }
        
        public void push(int val) {
            if (headStack == null) { // when all stacks are emtpy, create the new stack
                CustomStack newStack = new CustomStack(size++, capacity, null, null);
                headStack = newStack;
                leftMostNotFullStack = newStack;
                rightMostNotEmptyStack = newStack;
            }
            if (leftMostNotFullStack.isFull()) { // find the left most not full stack
                while (leftMostNotFullStack.next != null) { 
                    leftMostNotFullStack = leftMostNotFullStack.next;
                    if (!leftMostNotFullStack.isFull()) break;
                }
                if (leftMostNotFullStack.isFull() 
                && leftMostNotFullStack.next == null) { // when all stacks are full, create the new stack
                    CustomStack newStack = new CustomStack(size++, capacity, leftMostNotFullStack, null);
                    leftMostNotFullStack.next = newStack;
                    leftMostNotFullStack = newStack;
                    rightMostNotEmptyStack = newStack;
                }
            }
            leftMostNotFullStack.push(val);
        }
        
        public int pop() {
            if (headStack == null || rightMostNotEmptyStack == null) return -1; // when all stacks are emtpy, return -1;
            if (rightMostNotEmptyStack.isEmpty()) {
                if (rightMostNotEmptyStack.prev == null) { // when all stacks are empty, clear the points and reutrn -1;
                    headStack = null;
                    leftMostNotFullStack = null;
                    rightMostNotEmptyStack = null;
                    size = 0;
                    return -1;
                }
                if (rightMostNotEmptyStack.next == null) {
                    rightMostNotEmptyStack.prev.next = null;
                    size--;
                }
                while (rightMostNotEmptyStack.prev != null) { 
                    rightMostNotEmptyStack = rightMostNotEmptyStack.prev;
                    if (!rightMostNotEmptyStack.isEmpty()) break;
                }
                if (rightMostNotEmptyStack.isEmpty()) { // when all stacks are empty, clear the points and reutrn -1;
                    headStack = null;
                    leftMostNotFullStack = null;
                    rightMostNotEmptyStack = null;
                    size = 0;
                    return -1;
                }
            }
            if (rightMostNotEmptyStack.index < leftMostNotFullStack.index) {
                leftMostNotFullStack = rightMostNotEmptyStack;
            }
            return rightMostNotEmptyStack.pop();
        }
        
        public int popAtStack(int index) {
            if (headStack == null) return -1;
            CustomStack curr = headStack;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
                if (curr == null) return -1;
            }
            if (curr.isEmpty()) {
                return -1;
            }
            int res = curr.pop();
            if (curr.index < leftMostNotFullStack.index) {
                leftMostNotFullStack = curr;
            }
            return res;
        }
    }
}
