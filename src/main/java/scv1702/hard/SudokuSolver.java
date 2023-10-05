package scv1702.hard;

public class SudokuSolver {
    boolean flag;

    public void solveSudoku(char[][] board) {
        boolean[][] rvisited = new boolean[9][9];
        boolean[][] cvisited = new boolean[9][9];
        boolean[][] svisited = new boolean[9][9];
        char[][] temp = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int sr = (i/3)*3;
                    int sc = (j/3)*3;
                    int sn = sr*9 + sc;
                    int d = board[i][j]-'0';
                    rvisited[i][d-1] = true;
                    cvisited[j][d-1] = true;
                    svisited[(sn / 3) / 3 + (sn / 3) % 3][d-1] = true;
                }
                temp[i][j] = board[i][j];
            }
        }
        helper(board, temp, rvisited, cvisited, svisited, 0);
    }

    public void helper(char[][] ans, char[][] board, boolean[][] rvisited, boolean[][] cvisited, boolean[][] svisited, int n) {
        if (flag) return ;
        if (n == board.length * board[0].length) {
            flag = true;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    ans[i][j] = board[i][j];
                }
            }
            return ;
        }
        int r = n / board.length;
        int c = n % board[0].length;
        int sr = (r/3)*3;
        int sc = (c/3)*3;
        int sn = sr*9 + sc;
        if (board[r][c] != '.') {
            helper(ans, board, rvisited, cvisited, svisited, n+1);
        } else {
            for (int d = 1; d <= 9; d++) {
                if (!(rvisited[r][d-1] || cvisited[c][d-1] || svisited[(sn / 3) / 3 + (sn / 3) % 3][d-1])) {
                    board[r][c] = Character.forDigit(d, 10);
                    rvisited[r][d-1] = true;
                    cvisited[c][d-1] = true;
                    svisited[(sn / 3) / 3 + (sn / 3) % 3][d-1] = true;
                    helper(ans, board, rvisited, cvisited, svisited, n+1);
                    board[r][c] = '.';
                    rvisited[r][d-1] = false;
                    cvisited[c][d-1] = false;
                    svisited[(sn / 3) / 3 + (sn / 3) % 3][d-1] = false;
                }
            }
        }
    }
}
