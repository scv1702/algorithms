class Solution {

    public boolean overed(char[][] board, int r, int c) {
        char stone = board[r][c];

        // 가로
        boolean win = true;
        for (int j = 0; j < 3; j++) {
            if (board[r][j] != stone) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // 세로
        win = true;
        for (int i = 0; i < 3; i++) {
            if (board[i][c] != stone) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // / 대각선
        int cnt = 1;
        for (int i = r+1, j = c-1; i < 3 && j >= 0; i++, j--) {
            if (board[i][j] == stone) {
                cnt += 1;
            }
        }
        for (int i = r-1, j = c+1; i >= 0 && j < 3; i--, j++) {
            if (board[i][j] == stone) {
                cnt += 1;
            }
        }
        if (cnt == 3) {
            return true;
        }

        // \ 대각선
        cnt = 1;
        for (int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == stone) {
                cnt += 1;
            }
        }
        for (int i = r+1, j = c+1; i < 3 && j < 3; i++, j++) {
            if (board[i][j] == stone) {
                cnt += 1;
            }
        }
        if (cnt == 3) {
            return true;
        }

        return false;
    }

    public boolean equals(char[][] a, char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean possible = false;

    public void dfs(char[][] status, char[][] board, int r, int c, int depth) {
        if (possible) {
            return ;
        }

        board[r][c] = (depth % 2 == 0) ? 'O' : 'X'; // 착수

        if (equals(status, board)) {
            possible = true;
            return ;
        }

        if (overed(board, r, c)) {
            return ;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    dfs(status, board, i, j, depth + 1);
                    board[i][j] = '.';
                }
            }
        }

        board[r][c] = '.';
    }

    public void clear(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }

    public int solution(String[] brd) {
        char[][] board = new char[3][3];
        char[][] status = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                status[i][j] = brd[i].charAt(j);
            }
        }

        clear(board);

        if (equals(status, board)) {
            return 1;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!possible) {
                    dfs(status, board, i, j, 0);
                } else {
                    return 1;
                }
            }
        }

        return 0;
    }
}