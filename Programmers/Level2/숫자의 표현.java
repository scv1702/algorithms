class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int j = i; j <= n; j++) {
                s += j;
                if (s > n) break;
                if (s == n) answer += 1;
            }
        }
        return answer;
    }
}
