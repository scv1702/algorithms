package scv1702.medium;

import java.util.*;

public class CourseScheduleII {
    public List<List<Integer>> createGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> graph = createGraph(numCourses, prerequisites);
        int[] res = new int[numCourses];
        int resIdx = 0;
        int[] indegree = new int[numCourses];
        for (int[] edge: prerequisites) {
            indegree[edge[0]] += 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int n = queue.poll();
            res[resIdx++] = n;
            for (int i = 0; i < graph.get(n).size(); i++) {
                int m = graph.get(n).get(i);
                indegree[m] -= 1;
                if (indegree[m] == 0)
                    queue.offer(m);
            }
        }
        if (resIdx < numCourses) return new int[0];
        return res;
    }
}