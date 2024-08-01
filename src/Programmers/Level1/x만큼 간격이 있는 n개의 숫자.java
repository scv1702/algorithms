/*
time complexity: O(N^2)
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                answer[j] += x;
            }
        }
        return answer;
    }
}
*/

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] + x; 
        }
        return answer;
    }
}
