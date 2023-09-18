package scv1702.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(matrix, i, 0, n-1);
        }
    }

    public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public void reverseRow(int[][] matrix, int r, int c1, int c2) {
        for (int i = 0; i <= (c1+c2)/2; i++) {
            swap(matrix, r, c1+i, r, c2-i);
        }
    }
}