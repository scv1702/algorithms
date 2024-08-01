import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> visited = new HashSet<>();
        int[] lookup = new int[n];
        for (int base = 1; base <= n; base++) {
            for (int i = 0; i < n; i++) {
                lookup[i] += elements[(base + i - 1) % n];
                visited.add(lookup[i]);
            }
        }
        return visited.size();
    }
}
