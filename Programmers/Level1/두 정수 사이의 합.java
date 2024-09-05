class Solution {
    public long solution(int a, int b) {
        long x = (long) Math.max(a, b);
        long y = (long) Math.min(a, b);
        return (x - y + 1) * (x + y) / 2;
    }
}
