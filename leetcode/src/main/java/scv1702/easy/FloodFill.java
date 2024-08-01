package scv1702.easy;

public class FloodFill {
    // 4방향으로 연결된 같은 색상의 칸을 주어진 색상으로 칠한다.
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, visited, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void helper(int[][] image, boolean[][] visited, int r, int c, int color, int original) {
        image[r][c] = color;
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length) {
                if (image[nr][nc] == original && !visited[nr][nc]) {
                    helper(image, visited, nr, nc, color, original);
                }
            }
        }
    }
}
