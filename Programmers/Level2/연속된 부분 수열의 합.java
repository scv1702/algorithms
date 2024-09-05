class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i-1] + sequence[i-1];
        }
        int[] answer = new int[2];
        int i = 0;
        int j = 1;
        int len = Integer.MAX_VALUE;
        while (i < j && i < n && j <= n) {
            if (sum[j] - sum[i] == k) {
                if (j-i < len) {
                    answer[0] = i;
                    answer[1] = j-1;
                    len = j-i;
                }
            }
            if (sum[j] - sum[i] < k) {
                j += 1;
            } else {
                if (j-1 > i+1 && sum[j-1] - sum[i+1] >= k) {
                    i += 1;
                    j -= 1;
                } else {
                    i += 1;
                }
            }
        }
        return answer;
    }
}
