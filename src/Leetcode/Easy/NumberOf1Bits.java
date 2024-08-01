package Leetcode.Easy;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int answer = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                answer += 1;
            }
            n = n >>> 1;
        }
        return answer;
    }
}