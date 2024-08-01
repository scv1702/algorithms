class Solution {
    public int solution(int n) {
        boolean[] sieve = new boolean[n+1]; // sieve[i] = false면 소수
        int answer = n-1;
        for (int i = 2; i <= n; i++) {
            if (!sieve[i]) { // i가 소수인 경우
                for (int j = 2 * i; j <= n; j += i) { // i를 제외한 i의 배수는 모두 소수가 아니다.
                    if (!sieve[j]) {
                        sieve[j] = true;
                        answer -= 1;
                    }
                }
            }
        }
        return answer;
    }
}
