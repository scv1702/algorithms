package scv1702.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public void helper(List<String> answer, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            answer.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            helper(answer, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(')');
            helper(answer, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        helper(answer, new StringBuilder(), 0, 0, n);
        return answer;
    }
}
