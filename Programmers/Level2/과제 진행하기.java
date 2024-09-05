import java.util.*;

class Solution {
    class Plan {
        String name;
        int start;
        int playtime;
        
        public Plan(String[] plan) {
            this.name = plan[0];
            this.start = toMinutes(plan[1]);
            this.playtime = Integer.parseInt(plan[2]);
        }
        
        public Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public int toMinutes(String time) {
        String[] splitedTime = time.split(":");
        return Integer.parseInt(splitedTime[0]) * 60 + Integer.parseInt(splitedTime[1]);
    }
        
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIndex = 0;
        Stack<Plan> stack = new Stack<>(); // 멈춘 과제를 저장하는 스택
        
        Plan[] planArray = new Plan[plans.length + 1];
        for (int i = 0; i < plans.length; i++) {
            planArray[i] = new Plan(plans[i]);
        } 
        planArray[plans.length] = new Plan("INF", 1000000, 0); // 마지막 과제 비교용
        
        // 과제 시작 시각 순으로 정렬
        Arrays.sort(planArray, (p1, p2) -> Integer.compare(p1.start, p2.start));
        
        int t = planArray[0].start; // 과제 시작 시간
        for (int i = 0; i < plans.length; i++) {
            // planArray[i]를 다음 과제 시작 시간 전에 끝낼 수 있는 경우
            if (t + planArray[i].playtime <= planArray[i+1].start) {
                answer[answerIndex++] = planArray[i].name;
                t = t + planArray[i].playtime; // 과제 수행
                // 잠시 멈춘 과제가 있다면, 멈춘 과제를 이어서 진행
                while (!stack.empty()) {
                    Plan topPlan = stack.pop();
                    if (t + topPlan.playtime <= planArray[i+1].start) {
                        answer[answerIndex++] = topPlan.name;
                        t = t + topPlan.playtime;
                    } else {
                        topPlan.playtime = topPlan.playtime - (planArray[i+1].start - t);
                        stack.push(topPlan);
                        break;
                    }
                }
            // planArray[i]를 다음 과제 시작 시간 전에 끝내지 못하는 경우
            } else {
                planArray[i].playtime = planArray[i].playtime - (planArray[i+1].start - t);
                stack.push(planArray[i]);
            }
            t = planArray[i+1].start;
        }
        
        return answer;
    }
}
