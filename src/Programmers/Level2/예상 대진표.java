import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a % 2 == 0 || a + 1 != b) {
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer += 1;
        }
        return answer;
    }
}
