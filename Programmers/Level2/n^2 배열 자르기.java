import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int answerLen = (int) (right - left + 1);
        int answerIdx = 0;
        int[] answer = new int[answerLen];
        
        int leftSection = (int) (left / n);
        int rightSection = (int) (right / n);
        int leftSectionIdx = (int) (left % n);
        int rightSectionIdx = (int) (right % n);
        
        if (leftSection == rightSection) {
            int element = leftSection + 1;
            if (leftSectionIdx < leftSection + 1) {
                for (int idx = leftSectionIdx; idx < Math.min(rightSectionIdx + 1, leftSection + 1); idx++) {
                    answer[answerIdx++] = element;
                }
                for (int idx = leftSection + 1; idx <= rightSectionIdx; idx++) {
                    answer[answerIdx++] = ++element;
                }
            } else {
                element = leftSectionIdx;
                for (int idx = leftSectionIdx; idx <= rightSectionIdx; idx++) {
                    answer[answerIdx++] = ++element;
                }
            }
            return answer;
        }
        
        int element = leftSection + 1;
        if (leftSectionIdx < leftSection + 1) {
            for (int idx = leftSectionIdx; idx < leftSection + 1; idx++) {
                answer[answerIdx++] = element;
            }
            for (int idx = leftSection + 1; idx < n; idx++) {
                answer[answerIdx++] = ++element;
            }
        } else {
            element = leftSectionIdx;
            for (int idx = leftSectionIdx; idx < n; idx++) {
                answer[answerIdx++] = ++element;
            }
        }
        
        for (int section = leftSection + 1; section < rightSection; section++) {
            element = section + 1;
            for (int idx = 0; idx < section + 1; idx++) {
                answer[answerIdx++] = element;
            }
            for (int idx = section + 1; idx < n; idx++) {
                answer[answerIdx++] = ++element;
            }
        }
        
        element = rightSection + 1;
        if (rightSectionIdx < rightSection + 1) {
            for (int idx = 0; idx <= rightSectionIdx; idx++) {
                answer[answerIdx++] = element;
            }
        } else {
            for (int idx = 0; idx < rightSection + 1; idx++) {
                answer[answerIdx++] = element;
            }
            for (int idx = rightSection + 1; idx <= rightSectionIdx; idx++) {
                answer[answerIdx++] = ++element;
            }
        }

        return answer;
    }
}

/*
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int answerLen = (int) (right - left + 1);
        int answerIdx = 0;
        int[] answer = new int[answerLen];
        
        for (long i = left; i <= right; i++) {
            int y = (int) (i / n);
            int x = (int) (i % n);
            int element = Math.max(x, y) + 1;
            answer[answerIdx++] = element;
        }

        return answer;
    }
}
*/
