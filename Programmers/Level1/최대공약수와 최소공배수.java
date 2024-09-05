class Solution {
    public int gcd(int n, int m) {
        if (n % m == 0) return m;
        return gcd(m, n % m);
    }
    
    public int[] solution(int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        int x = gcd(a, b);
        int[] answer = { x, a * b / x };
        return answer;
    }
}
