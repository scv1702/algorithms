import java.lang.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String[][] personalities = {
            { "R", "T" },
            { "C", "F" },
            { "J", "M" },
            { "A", "N" }
        };
        
        for (String[] personality: personalities) {
            map.put(personality[0], 0);
            map.put(personality[1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            String[] personality = survey[i].split("");
            int choice = choices[i];
            if (choice >= 1 && choice <= 3) {
                map.put(personality[0], map.get(personality[0]) + 4 - choice);
            } else if (choice >= 5 && choice <= 7) {
                map.put(personality[1], map.get(personality[1]) + choice - 4);
            }
        }
        
        for (String[] personality: personalities) {
            if (map.get(personality[0]) >= map.get(personality[1])) {
                sb.append(personality[0]);
            } else {
                sb.append(personality[1]);
            }
        }
        
        return sb.toString();
    }
}
