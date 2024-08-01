class Solution {
    public int solution(int n) {
        if (n <= 1) return n;
        int remainder = 1234567;
        int i = 0;
        int j = 1;
        for (int k = 2; k <= n; k++) {
            int temp = j;
            j = i % remainder + j % remainder;
            i = temp;
        }
        return j % remainder;
    }
}
