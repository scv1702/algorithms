import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int t: tangerine) {
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> countsAsList = new ArrayList<>(counts.entrySet());
        countsAsList.sort(Map.Entry.comparingByValue());
        for (int i = countsAsList.size()-1; i >= 0; i--) {
            int count = countsAsList.get(i).getValue();
            k -= count;
            answer += 1;
            if (k <= 0) break;
        }
        return answer;
    }
}
