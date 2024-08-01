class Solution {
    public long solution(int price, int money, int count) {
        long fee = ((long) count * price) * (count + 1) / 2;
        return Math.max(0, fee - money);
    }
}
