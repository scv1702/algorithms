package Leetcode.Hard.NQueensII;

public class NQueensIINaive {
    boolean[][] chessboard;
    int answer;
    
    public int totalNQueens(int n) {
        chessboard = new boolean[n][n];
        helper(n, 0);
        return answer;
    }
    
    public void helper(int n, int depth) {
        if (depth == n) {
            answer += 1;
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (check(n, depth, i)) {
                chessboard[depth][i] = true;
                helper(n, depth + 1);
                chessboard[depth][i] = false;
            }
        }
    }
    
    public boolean check(int n, int depth, int i) {
        // 수직 검사
        for (int r = depth-1; r >= 0; r--) {
            if (chessboard[r][i]) return false;
        }
        // 오른쪽 대각선 검사
        for (int r = depth-1, c = i+1; r >= 0 && c < n; r--, c++) {
            if (chessboard[r][c]) return false;
        }
        // 왼쪽 대각선 검사
        for (int r = depth-1, c = i-1; r >= 0 && c >= 0; r--, c--) {
            if (chessboard[r][c]) return false;
        }
        return true;
    }
}