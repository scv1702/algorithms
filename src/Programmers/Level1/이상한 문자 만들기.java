class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            while (i < c.length && c[i] == ' ') i++;
            int j = 0;
            while (i < c.length && c[i] != ' ') {
                if (j % 2 == 0) {
                    c[i] = Character.toUpperCase(c[i]);
                } else {
                    c[i] = Character.toLowerCase(c[i]);
                }
                i++;
                j++;
            }
        }
        return new String(c);
    }
}
