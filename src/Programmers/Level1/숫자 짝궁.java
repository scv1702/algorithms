import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        X.chars().forEach(c -> {
            int i = c - '0';
            cntX[i]++;
        });
        Y.chars().forEach(c -> {
            int i = c - '0';
            cntY[i]++;
        });
        
        for (int i = 9; i >= 0; i--) {
            if (cntX[i] > 0 && cntY[i] > 0) { // 공통으로 나타나는 정수인 경우
                sb.append(Integer.toString(i).repeat(Math.min(cntX[i], cntY[i])));
            }
        }
        
        String answer = sb.toString();
        
        if (answer.equals("")) {
            return "-1";
        } else if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}
