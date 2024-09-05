class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = n;
        while (cola >= a) {
            answer = answer + (cola / a) * b;
            cola = (cola / a) * b + cola % a;
        }
        return answer;
    }
}
