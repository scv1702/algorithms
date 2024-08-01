class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long) Math.sqrt(n);
        if (Double.compare(Math.pow(sqrt, 2), n) == 0) {
            return (long) Math.pow(sqrt + 1, 2);
        }
        return -1;
    }
}
