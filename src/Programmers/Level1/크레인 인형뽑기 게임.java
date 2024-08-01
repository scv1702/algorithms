import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int[] ptrs = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (board[j][i] <= 0) j++;
            ptrs[i] = j;
        }
        
        for (int move: moves) {
            if (ptrs[move-1] < n) {
                int doll = board[ptrs[move-1]][move-1];
                board[ptrs[move-1]++][move-1] = 0;
                if (!stack.empty() && doll == stack.peek()) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(doll);
                }
            }
        }
        
        return 2 * answer;
    }
}
