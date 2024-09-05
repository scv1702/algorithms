import java.util.*;

class Solution {
    static final int DIA = 0;
    static final int IRON = 1;
    static final int STONE = 2;
    
    class Permutation {
        int[] arr;
        List<List<Integer>> res;
        boolean[] visited;
        int n;
        
        public Permutation(int[] picks) {
            res = new ArrayList<>();
            for (int pick: picks) {
                n += pick;
            }
            arr = new int[n];
            int arrIdx = 0;
            for (int i = 0; i < picks.length; i++) {
                for (int j = 0; j < picks[i]; j++) {
                    arr[arrIdx++] = i;
                }
            }
            visited = new boolean[n];    
            helper(new ArrayList<>(), 0);
        }
        
        public void helper(List<Integer> temp, int depth) {
            if (depth == n) {
                res.add(new ArrayList<>(temp));
                return ;
            } 
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && arr[i] != prev) {
                    visited[i] = true;
                    temp.add(arr[i]);
                    prev = arr[i];
                    helper(temp, depth+1);
                    visited[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        // fatigue[pick][mineral] = pick으로 mineral을 캘 때 피로도
        int[][] fatigues = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
        }; 
        int answer = Integer.MAX_VALUE;
        Permutation permutation = new Permutation(picks);
        for (List<Integer> p: permutation.res) {
            int fatigue = 0;
            int durability = 0;
            int pick = p.remove(0);
            for (String mineral: minerals) {
                if ("diamond".equals(mineral)) {
                    fatigue += fatigues[pick][DIA];
                }
                if ("iron".equals(mineral)) {
                    fatigue += fatigues[pick][IRON];
                }
                if ("stone".equals(mineral)) {
                    fatigue += fatigues[pick][STONE];
                }
                if (answer <= fatigue) break;
                durability += 1;
                if (durability >= 5) {
                    durability = 0;
                    if (p.size() <= 0) break;
                    pick = p.remove(0);
                }
            }
            answer = Math.min(answer, fatigue);
        }
        return answer;
    }
}
