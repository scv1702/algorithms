import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String p: completion) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        for (String p: participant) {
            if (map.containsKey(p) && map.get(p) > 0) {
                map.put(p, map.get(p) - 1);
            } else {
                answer = p;
            }
        }
        return answer;
    }
}
