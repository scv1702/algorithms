import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        if (arr.length > 0) {
            int prev = -1;
            for (int i = 0; i < arr.length; i++) {
                if (prev != arr[i]) {
                    answer.add(arr[i]);
                    prev = arr[i];
                }
            }  
        }
        
        return answer;
    }
}
