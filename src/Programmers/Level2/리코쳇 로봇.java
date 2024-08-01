import java.util.*;

class Solution {
    class Pair {
        int v;
        int distance;
        
        public Pair(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }
    
    public int findSource(String[] board) {
        int source = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if ('R' == board[i].charAt(j)) {
                    source = i * board[0].length() + j;
                    break;
                }
            }
        }
        return source;
    }
    
    public int findDestination(String[] board) {
        int destination = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if ('G' == board[i].charAt(j)) {
                    destination = i * board[0].length() + j;
                    break;
                }
            }
        }
        return destination;
    }
    
    public boolean isValidRange(String[] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length();
    }
    
    public int solution(String[] board) {
        int answer = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[] visited = new boolean[board.length * board[0].length()];
        int source = findSource(board);
        int destination = findDestination(board);
        queue.offer(new Pair(source, 0));
        visited[source] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int v = pair.v;
            int distance = pair.distance;
            if (v == destination) {
                return distance;
            }
            int i = v / board[0].length();
            int j = v % board[0].length();
            for (int[] dir: dirs) {
                int ni = i;
                int nj = j;
                while (isValidRange(board, ni, nj) && 'D' != board[ni].charAt(nj)) {
                    ni += dir[0];
                    nj += dir[1];
                }
                ni -= dir[0];
                nj -= dir[1];
                int nv = ni * board[0].length() + nj; 
                if (!visited[nv]) {
                    queue.offer(new Pair(nv, distance + 1));
                    visited[nv] = true;
                }
            }
        }
        return -1;
    }
}
