import java.util.*;

class Solution {
    // 중앙에는 노란색, 테두리 1줄은 갈색
    // 2(x+y) - 4 = brown, (x-2)*(y-2) = yellow을 만족하는 x, y를 찾아라.
    // 2x + 2y - 4 = brown, xy - 2x - 2y + 4 = yellow
    // xy = brown + yellow
    // 2x + 2(brown+yellow)/x - 4 = brown
    // 2x^2 - (brown+4)x + 2(brown+yellow) = 0
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int a = 2;
        int b = -4-brown;
        int c = 2*(brown+yellow);
        double d = b*b - 4*a*c;
        int x = (int) (-b + Math.sqrt(d)) / (2*a);
        int y = (brown+yellow)/x;
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
