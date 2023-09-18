package scv1702.medium;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasOneInRow = false;
        boolean hasOneInCol = false;
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                hasOneInRow = true;
                break;
            }
        }
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                hasOneInCol = true;
                break;
            }
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for (int r = 1; r < m; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < n; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        for (int c = 1; c < n; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        if (hasOneInRow) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }
        if (hasOneInCol) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}