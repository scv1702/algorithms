class Solution {
    public long solution(int n) {
        if (n <= 2) return n;
        long remainder = 1234567;
        long i = 1;
        long j = 1;
        for (int k = 2; k <= n; k++) {
            long temp = j;
            j = i % remainder + j % remainder;
            i = temp;
        }
        return j % remainder;
    }
}
