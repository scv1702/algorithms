package scv1702.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    Map<Character, String> lookup;
    List<String> res;

    public void solve(List<String> s) {
        boolean[][] visited = new boolean[s.size()][4];
        helper(s, visited, 0, new StringBuilder());
    }

    public void helper(List<String> s, boolean[][] visited, int depth, StringBuilder sb) {
        if (depth == s.size()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.get(depth).length(); i++) {
            if (!visited[depth][i]) {
                visited[depth][i] = true;
                sb.append(s.get(depth).charAt(i));
                helper(s, visited, depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[depth][i] = false;
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return new ArrayList<>();
        lookup = new HashMap<>();
        lookup.put('2', "abc");
        lookup.put('3', "def");
        lookup.put('4', "ghi");
        lookup.put('5', "jkl");
        lookup.put('6', "mno");
        lookup.put('7', "pqrs");
        lookup.put('8', "tuv");
        lookup.put('9', "wxyz");
        res = new ArrayList<>();
        List<String> s = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            s.add(lookup.get(digits.charAt(i)));
        }
        solve(s);
        return res;
    }
}
