import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer[]> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Integer[] value = {i, j};
                map.put(3 * i + j + 1, value);
            }
        }
        
        Integer[] value = { 3, 1 };
        map.put(0, value);
        
        int li = 3;
        int lj = 0;
        int ri = 3;
        int rj = 2;
        
        for (int number: numbers) {
            Integer[] coordinate = map.get(number);
            int i = coordinate[0];
            int j = coordinate[1];
            String h = "";
            
            if (number % 3 == 1) { // 1, 4, 7
                h = "L";
            } else if (number > 0 && number % 3 == 0) { // 3, 6, 9
                h = "R";
            } else { // 2, 5, 8, 0
                int ld = Math.abs(i - li) + Math.abs(j - lj);
                int rd = Math.abs(i - ri) + Math.abs(j - rj);
                if (ld < rd) {
                    h = "L";
                } else if (ld > rd) {
                    h = "R";
                } else if (ld == rd) {
                    if (hand.equals("left")) {
                        h = "L";
                    } else {
                        h = "R";
                    }
                }
            }
            sb.append(h);
            if (h.equals("L")) {
                li = i;
                lj = j;
            } else {
                ri = i;
                rj = j;
            }
        }
        
        return sb.toString();
    }
}
