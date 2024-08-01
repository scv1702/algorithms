class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P' || s.charAt(i) == 'p')
                p += 1;
            if (s.charAt(i) == 'Y' || s.charAt(i) == 'y')
                y += 1;
        }
        return (p == y);
    }
}
