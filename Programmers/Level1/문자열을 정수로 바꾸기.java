class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        boolean isMinus = s.startsWith("-") || s.startsWith("+");
        
        if (isMinus) {
            i = 1;
        }
        while (i < s.length()) {
            answer *= 10;
            answer += s.charAt(i) - '0';
            i++;
        }
        if (isMinus) answer *= -1;
        
        return answer;
    }
}
