import java.util.*;

class Task {
    int number;
    int deployDate;
    
    public Task(int number, int deployDate) {
        this.number = number; this.deployDate = deployDate;
    }
    
    @Override
    public String toString() {
        return "[" + number + ", " + deployDate + "]";
    }
}

class Solution { 
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Task> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Task(i, (int) Math.ceil((100 - progresses[i]) / (double) speeds[i])));
        }
        
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            int taskCount = 1;
            while (!queue.isEmpty() && task.deployDate >= queue.peek().deployDate) {
                queue.poll();
                taskCount++;
            } 
            answer.add(taskCount);
        }
          
        return answer;
    }
}
