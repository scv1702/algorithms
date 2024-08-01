import java.util.*;

class Process {
    int number;
    int priority;
    
    public Process(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return "[" + number + ", " + priority + "]";
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Process> queue = new ArrayDeque<>();
        int answer = 0;
        
        for (int number = 0; number < priorities.length; number++) {
            queue.offer(new Process(number, priorities[number]));
        }
        
        Arrays.sort(priorities);
        
        int priorityIndex = priorities.length - 1;
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            if (process.priority < priorities[priorityIndex]) {
                queue.offer(process);
            } else {
                answer++;
                if (process.number == location) {
                    break;
                } else {
                    priorityIndex--;
                }
            } 
        }
         
        return answer;
    }
}
