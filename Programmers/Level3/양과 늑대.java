import java.util.*;

class Solution {

    private static final int SHEEP = 0;
    private static final int WOOLF = 1;

    private int sheep = 0;
    private int woolf = 0;
    private int answer = 0;

    public void helper(
        List<List<Integer>> tree,
        int[] info,
        boolean[] visited,
        int u,
        int prevSheep,
        int prevWoolf
    ) {
        int sheep = prevSheep;
        int woolf = prevWoolf;

        if (info[u] == SHEEP) {
            sheep += 1;
        } else {
            woolf += 1;
        }
        if (woolf >= sheep) {
            sheep = 0;
            return ;
        }

        answer = Math.max(answer, sheep);
        visited[u] = true;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                for (int v : tree.get(i)) {
                    if (!visited[v]) {
                        helper(tree, info, visited, v, sheep, woolf);
                        visited[v] = false;
                    }
                }
            }
        }
    }

    // 트리 방문하며 최대한 모을 수 있는 양 개수 구하기
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        boolean[] visited = new boolean[info.length];

        // 트리 초기화
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            tree.get(u).add(v);
        }

        helper(tree, info, visited, 0, 0, 0);

        return answer;
    }
}