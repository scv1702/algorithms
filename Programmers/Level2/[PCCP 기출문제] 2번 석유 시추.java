import java.util.*;

class Solution {
    class ConnectedComponent {
        int size = 0;
        Set<Integer> nodes = new HashSet<>();

        public void add(int node) {
            nodes.add(node);
            connectedComponents[node / m][node % m] = this;
            size += 1;
        }
    }
    
    static final int EMPTY = 0;
    static final int OIL = 1;
    static final int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    
    static int n;
    static int m;
    
    boolean[][] visited;
    ConnectedComponent[][] connectedComponents;
    int drilledOil = 0; 
    
    public boolean validate(int i, int j, int[][] land) {
        return (i >= 0 && i < n && j >= 0 && j < m) && (land[i][j] == OIL && !visited[i][j]);
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        connectedComponents = new ConnectedComponent[n][m];
        visited = new boolean[n][m];
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!validate(i, j, land)) {
                    continue;
                }
                ConnectedComponent connectedComponent = new ConnectedComponent();
                queue.offer(i * m + j);
                connectedComponent.add(i * m + j);
                visited[i][j] = true;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    int r = node / m;
                    int c = node % m;
                    for (int k = 0; k < dirs.length; k++) {
                        int[] dir = dirs[k];
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (validate(nr, nc, land)) {
                            queue.offer(nr * m + nc);
                            connectedComponent.add(nr * m + nc);
                            visited[nr][nc] = true;
                        }                
                    }
                }
            }
        }
        
        for (int j = 0; j < m; j++) {
            int temp = 0;
            Set<ConnectedComponent> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                ConnectedComponent connectedComponent = connectedComponents[i][j];
                if (land[i][j] == OIL & !set.contains(connectedComponent)) {
                    set.add(connectedComponent);
                    temp += connectedComponent.size;
                }
            }
            answer = Math.max(temp, answer);
        }
        
        return answer;
    }
}
