package Leetcode.Medium;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] refCnts = getReferenceCounts(s1);
        int i = 0;
        while (i <= s2.length()-s1.length()) {
            if (refCnts[s2.charAt(i)-'a'] > 0) {
                int ni = _checkInclusion(s1, s2, i);
                if (ni < 0) return true;
                i = ni;
            } else {
                i++;
            }
        }
        return false;
    }

    public int[] getReferenceCounts(String s) {
        int[] refCnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            refCnts[s.charAt(i)-'a']++;
        }
        return refCnts;
    }

    public int _checkInclusion(String s1, String s2, int i) {
        int[] refCnts = getReferenceCounts(s1);
        for (int j = i+s1.length()-1; j >= i; j--) {
            if (refCnts[s2.charAt(j)-'a'] == 0) {
                return j+1;
            }
            refCnts[s2.charAt(j)-'a']--;
        }
        for (int j = i; j < i+s1.length(); j++) {
            if (refCnts[s2.charAt(j)-'a'] > 0 || refCnts[s2.charAt(j)-'a'] < 0) {
                return j;
            }
        }
        return -1;
    }
}