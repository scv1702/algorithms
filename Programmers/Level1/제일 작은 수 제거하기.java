import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        if (arr.length <= 1) {
            answer.add(-1);
        } else {
            int min = arr[0];

            for (int a: arr) {
                if (a < min) min = a;
            }
            
            for (int a: arr)
                if (a != min) answer.add(a);
        }
        
        return answer;
    }
}
