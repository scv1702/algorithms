public class Solution {
    public int solution(int n) {
        if (n == 1) return 1;
        int answer = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            if (n % 2 != 0) {
                n -= 1;
                answer += 1;
            }
        }
        return answer;
    }
}
