class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr1.length;
        int row = arr1[0].length;
        int[][] answer = new int[col][row];
        for (int c = 0; c < col; c++)
            for (int r = 0; r < row; r++)
                answer[c][r] = arr1[c][r] + arr2[c][r];
        return answer;
    }
}