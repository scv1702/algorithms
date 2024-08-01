package Leetcode.Medium;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    // (ui, uj) ~ (di, dj)에서 target을 탐색
    // (ui, uj) ~ (di, dj) 안의 원소들은 matrix[ui][uj]보다 크거나 같고, matrix[di][dj]보다 작거나 같다.
    public boolean searchMatrix(int[][] matrix, int target, int ui, int uj, int di, int dj) {
        if (ui > di || uj > dj)
            return false;
        if (ui < 0 || ui >= matrix.length || di < 0 || di >= matrix.length)
            return false;
        if (uj < 0 || uj >= matrix[0].length || uj < 0 || uj >= matrix[0].length)
            return false;
        if (matrix[ui][uj] > target || matrix[di][dj] < target)
            return false;
        int mi = (ui + di) / 2;
        int mj = (uj + dj) / 2;
        if (matrix[mi][mj] == target)
            return true;
        if (matrix[mi][mj] < target) {
            return searchMatrix(matrix, target, ui, mj + 1, mi, dj) || searchMatrix(matrix, target, mi + 1, uj, di, dj);
        }
        return searchMatrix(matrix, target, ui, uj, di, mj - 1) || searchMatrix(matrix, target, ui, mj, mi - 1, dj);
    }
}
