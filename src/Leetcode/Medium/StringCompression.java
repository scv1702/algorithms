package Leetcode.Medium;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1) return 1;
        int answer = 0;
        int gl = 0;
        int ci = 0;
        char gc = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == gc) gl++;
            else {
                chars[ci++] = gc;
                answer++;
                if (gl > 1) {
                    String _gl = Integer.toString(gl);
                    for (int j = 0; j < _gl.length(); j++) {
                        chars[ci++] = (char) _gl.charAt(j);
                        answer++;
                    } 
                }
                gl = 1;
                gc = chars[i];
            }
        }
        chars[ci++] = gc;
        answer++;
        if (gl > 1) {
            String _gl = Integer.toString(gl);
            for (int j = 0; j < _gl.length(); j++) {
                chars[ci++] = (char) _gl.charAt(j);
                answer++;
            } 
        }
        return answer;
    }
}
