import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> failureMap = new HashMap<>();
        Map<Integer, Double> failureRateMap = new HashMap<>();
        int maxStage = 0;
        
        for (int stage: stages) {
            if (stage < N+1) {
                failureMap.put(stage, failureMap.getOrDefault(stage, 0) + 1);
                if (stage > maxStage) {
                    maxStage = stage;
                }
            }
        }
        
        int challenger = stages.length;
        for (int stage = 1; stage <= N; stage++) {
            int failure = failureMap.getOrDefault(stage, 0);
            double failureRate = failure == 0 ? 0 : (double) failure / challenger;
            failureRateMap.put(stage, failureRate);
            challenger -= failure;
        }
        
        List<Map.Entry<Integer, Double>> failureRateList = new ArrayList<>(failureRateMap.entrySet());
        failureRateList.sort((e1, e2) -> Double.compare(failureRateMap.get(e2.getKey()), failureRateMap.get(e1.getKey())));
        
        for (Map.Entry<Integer, Double> entry: failureRateList) {
            answer.add(entry.getKey());
        }
        
        return answer;
    }
}
