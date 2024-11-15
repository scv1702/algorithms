import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = 0;
        while (sb.length() != 1 || sb.charAt(0) != '1') {
            int t = 0;
            for (int k = 0; k < sb.length(); k++) {
                char c = sb.charAt(k);
                if (c == '0') {
                    t += 1;
                }
            }
            sb = new StringBuilder(Integer.toBinaryString(sb.length()-t));
            i += 1;
            j += t;
        }
        int[] answer = {i, j};
        return answer;
    }

    public int[] solutionV2(String s) {
        int b = 0;
        int z = 0;

        while (!s.equals("1")) {
            int size = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    size += 1;
                } else {
                    z += 1;
                }
            }
            s = Integer.toString(size, 2);
            b += 1;
        }

        return new int[] { b, z };
    }
}
