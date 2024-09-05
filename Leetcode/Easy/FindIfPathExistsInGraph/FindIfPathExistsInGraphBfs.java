package Leetcode.Easy.FindIfPathExistsInGraph;

import java.util.*;

public class FindIfPathExistsInGraphBfs {
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

    public boolean validPath(int n, List<List<Integer>> adjList, int source, int destination) {
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[destination]) return true;
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int nextNode = adjList.get(node).get(i);
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = createAdjList(n, edges);
        return validPath(n, adjList, source, destination);
    }
}