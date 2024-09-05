class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public int solution(int[] arr) {
        int answer = 1;
        for (int n: arr) {
            answer = lcm(answer, n);
        }
        return answer;
    }
}
