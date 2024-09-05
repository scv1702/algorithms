import java.util.*;

class Solution {
    public boolean check(Map<String, Integer> map, String[] discount, int first) {
        for (int i = first; i < first + 10; i++) {
            if (map.get(discount[i]) == null) {
                return false;
            }
            map.put(discount[i], map.get(discount[i]) - 1);
        }
        for (Integer amount: map.values()) {
            if (amount > 0) return false;
        }
        map.clear();
        map = null;
        return true;
    } 
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int first = 0; first < discount.length - 9; first++) {
            Map<String, Integer> temp = new HashMap<>();
            temp.putAll(map);
            if (check(temp, discount, first)) {
                answer += 1;
            }
        }
        return answer;
    }
}
