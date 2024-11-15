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

    public int[] solutionV2(int brown, int yellow) {
        int w = 3; // 최소 3, 최대 2,000,002
        int h = 3; // 최소 3

        for (; w <= 2_000_002; w++) {
            h = ((brown - 2 * w) / 2) + 2;
            if (w < h) continue;
            int yw = w - 2;
            if (yellow % yw != 0) continue;
            int yh = yellow / yw;
            if (yw + 2 == w && yh + 2 == h) {
                break;
            }
        }

        return new int[] { w, h };
    }
}
