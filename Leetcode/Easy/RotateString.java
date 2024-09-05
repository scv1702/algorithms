package Leetcode.Easy;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        StringBuilder sb = new StringBuilder(goal);
        for (int i = 0; i < goal.length(); i++) {
            sb.append(goal.charAt(i));
        }
        return sb.toString().contains(s);
    }
}