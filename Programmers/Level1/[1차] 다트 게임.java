class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int i = 0;
        int n = dartResult.length();
        int prevScore = 0;
        while (i < n) {
            int score = 0;
            // 점수 계산
            while (Character.isDigit(dartResult.charAt(i))) {
                score *= 10;
                score += dartResult.charAt(i++) - '0';
            }
            // 보너스 계산
            switch (dartResult.charAt(i++)) {
                case 'D':
                    score = (int) Math.pow(score, 2);
                    break;
                case 'T':
                    score = (int) Math.pow(score, 3);
                    break;
                default:
                    break;
            }
            // 옵션 계산
            if (i < n) {
                switch (dartResult.charAt(i)) {
                    case '*':
                        answer += prevScore;
                        score *= 2;
                        i++;
                        break;
                    case '#':
                        score *= -1;
                        i++;
                        break;
                    default:
                        break;
                }
            }
            answer += score;
            prevScore = score;
        }
        return answer;
    }
}
