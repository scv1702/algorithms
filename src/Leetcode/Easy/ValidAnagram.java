package Leetcode.Easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] refCnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            refCnts[idx] += 1;
            idx = t.charAt(i) - 'a';
            refCnts[idx] -= 1;
        }
        for (int refCnt: refCnts) {
            if (refCnt != 0) return false;
        }
        return true;
    }
}