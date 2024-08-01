import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] command: commands) {
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2] - 1;
            int[] arr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(arr);
            answer.add(arr[k]);
        }
        
        return answer;
    }
}
