package scv1702.easy.FindIfPathExistsInGraph;

import java.util.*;

public class FindIfPathExistsInGraphDfs {
    public List<List<Integer>> createAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int node = 0; node < n; node++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = createAdjList(n, edges);
        boolean[] visited = new boolean[n];
        dfs(adjList, visited, source);
        return visited[destination];
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < adjList.get(node).size(); i++) {
            int nextNode = adjList.get(node).get(i);
            if (!visited[nextNode]) {
                dfs(adjList, visited, nextNode);
            }
        }
    }
}