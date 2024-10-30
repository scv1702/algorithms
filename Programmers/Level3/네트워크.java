class Solution {

    private int component_count = 0;

    public void dfs_helper(int num, int[][] graph, boolean[] visited) {
        visited[num] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[num][i] == 1 && !visited[i]) {
                dfs_helper(i, graph, visited);
            }
        }
    }

    public void dfs(int num, int[][] graph, boolean[] visited) {
        if (!visited[num]) {
            this.component_count += 1;
            dfs_helper(num, graph, visited);
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, computers, visited);
        }
        return component_count;
    }
}