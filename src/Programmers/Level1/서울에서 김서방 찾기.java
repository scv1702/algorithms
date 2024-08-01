class Solution {
    public String solution(String[] seoul) {
        int answer = 0;
        for (String s: seoul) {
            if (s.equals("Kim")) break;
            answer += 1;
        }
        return "김서방은 " + Integer.toString(answer) + "에 있다";
    }
}
