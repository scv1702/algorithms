import java.util.*;

class Solution {

    private int answer = Integer.MAX_VALUE;

    private boolean allCleaned(boolean[] cleaned) {
        for (int i = 0; i < cleaned.length; i++) {
            if (!cleaned[i]) {
                return false;
            }
        }
        return true;
    }

    private void permute(
        int n, int[] dist, int[] weak, boolean[] cleaned, int depth
    ) {
        if (allCleaned(cleaned)) {
            answer = Math.min(answer, depth);
            return ;
        }

        if (depth >= answer || depth >= dist.length) {
            return ;
        }

        for (int i = 0; i < weak.length; i++) {
            if (cleaned[i]) continue;
            boolean[] newCleaned = new boolean[cleaned.length];
            System.arraycopy(
                cleaned,
                0,
                newCleaned,
                0,
                cleaned.length
            );
            int j = i; // 시작 위치
            int d = 0; // 이동 거리
            while (d <= dist[depth]) {
                if (newCleaned[j]) {
                    break;
                }
                newCleaned[j] = true;
                int nj;
                int nd;
                if (j + 1 < weak.length) {
                    nj = j + 1;
                    nd = d + (weak[nj] - weak[j]);
                } else {
                    nj = 0;
                    nd = d + ((n - weak[j]) + weak[nj]);
                }
                if (nd > dist[depth]) {
                    break;
                }
                j = nj;
                d = nd;
            }
            permute(n, dist, weak, newCleaned, depth + 1);
        }
    }

    private int[] reverseSort(int[] array) {
        int[] res = new int[array.length];
        Arrays.sort(array);
        for (int i = 0; i < res.length; i++) {
            res[i] = array[array.length - 1 - i];
        }
        return res;
    }

    public int solution(int n, int[] weak, int[] dist) {
        int[] sortedDist = reverseSort(dist);
        boolean[] cleaned = new boolean[weak.length];
        permute(n, sortedDist, weak, cleaned, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}