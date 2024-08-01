class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int i = x;
        int j = 0;
        while (i > 0) {
            j += i % 10;
            i /= 10;
        }
        if (x % j != 0)
            answer = false;
        return answer;
    }
}
