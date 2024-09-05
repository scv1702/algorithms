import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder sb = new StringBuilder();
        Set<String> keySet = map.keySet();
        
        s.chars().forEach(c -> {
            if (c < 97) {
                answer.append(Character.toString(c));
            } else {
                sb.append(Character.toString(c));
                if (keySet.contains(sb.toString())) {
                    answer.append(map.get(sb.toString()));
                    sb.setLength(0);
                }
            }
        });
    
        return Integer.parseInt(answer.toString());
    }
}
